package com.migufun.pojo;

/**
 * @author NJR10byh
 * @date 2022/8/4 17:26:01
 * @description
 */

public class Account {
    private int id;
    private String name;
    private Double money;

    public Account() {
    }

    public Account(int id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}