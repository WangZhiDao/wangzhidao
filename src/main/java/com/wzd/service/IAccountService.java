package com.wzd.service;

/**
 * 业务层接口
 * @author wr847214947@163.com
 * @date 2020/6/23 15:07
 */
public interface IAccountService {
    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money  金额
     */
    public void transfer(String sourceName, String targetName, Float money);
}
