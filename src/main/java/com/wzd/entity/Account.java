package com.wzd.entity;

/**
 * @author wr847214947@163.com
 * @date 2020/6/23 14:55
 */
public class Account {
    Integer id;
    String name;
    Float money;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
