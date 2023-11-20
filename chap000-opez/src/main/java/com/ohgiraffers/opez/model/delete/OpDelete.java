package com.ohgiraffers.opez.model.delete;

public class OpDelete {
    private String userName;

    public OpDelete() {
    }

    public OpDelete(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "OpDelete{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
