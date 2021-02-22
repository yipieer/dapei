package com.entity;

import java.util.Objects;

public class Accounts {

    private String userName;//用户名
    private String password;//密码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Accounts accounts = (Accounts) object;
        return Objects.equals(userName, accounts.userName) && Objects.equals(password, accounts.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public Accounts(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
