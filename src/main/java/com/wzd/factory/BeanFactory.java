package com.wzd.factory;

import com.wzd.service.IAccountService;
import com.wzd.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理工厂
 * @author wr847214947@163.com
 * @date 2020/6/23 15:30
 */
@Component("beanFactory")
public class BeanFactory {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean(name = "proxyAccountService")
    public IAccountService getAccountService(){
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            Object value = null;
                            transactionManager.beginTransaction();
                            value = method.invoke(accountService, args);
                            transactionManager.commit();
                            return value;
                        }catch (Exception e){
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            transactionManager.release();
                        }
                    }
                });
    }


}
