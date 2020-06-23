package com.wzd.dao;

import com.wzd.entity.Account;

/**
 * 持久层接口
 * @author wr847214947@163.com
 * @date 2020/6/23 14:52
 */
public interface IAccountDao {

    /**
     * 根据名称查询数据
     * @param name 名称
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account  account对象
     */
    void updateAccount(Account account);
}
