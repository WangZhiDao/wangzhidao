package com.wzd.dao.impl;

import com.sun.xml.internal.ws.api.server.InstanceResolverAnnotation;
import com.wzd.dao.IAccountDao;
import com.wzd.entity.Account;
import com.wzd.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层实现类
 * @author wr847214947@163.com
 * @date 2020/6/23 14:57
 */
@Repository(value="accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 根据参数查询数据
     * @param name  名称
     * @return
     */
    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name = ?",
                    new BeanListHandler<Account>(Account.class), name);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if( accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，请检查数据");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新账户
     *
     * @param account account对象
     */
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name=?, money=? where id = ?",
                  account.getName(), account.getMoney(), account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
