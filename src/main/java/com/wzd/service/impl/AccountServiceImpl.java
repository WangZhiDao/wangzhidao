package com.wzd.service.impl;

import com.wzd.dao.IAccountDao;
import com.wzd.entity.Account;
import com.wzd.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 业务层实现类
 * @author wr847214947@163.com
 * @date 2020/6/23 15:08
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账
     *
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money  金额
     */
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer--------");
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
//        int i = 1/0;
        accountDao.updateAccount(target);
        System.out.println("转账成功！！！");
    }
}
