package com.migufun.pojo;

/**
 * @author NJR10byh
 * @date 2022/8/10 11:23:34
 * @description
 */

public class userInfo {
    private String username;
    private String password;

    public userInfo() {
    }

    public userInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "usseInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
