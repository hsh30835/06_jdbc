package com.ohgiraffers.opez.model.update;

public class OpUpdate {
    private String changeName;
    private String userName;
    private String userTier;

    public OpUpdate() {
    }

    public OpUpdate(String changeName, String userName, String userTier) {
        this.changeName = changeName;
        this.userName = userName;
        this.userTier = userTier;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    @Override
    public String toString() {
        return "OpUpdate{" +
                "changeName='" + changeName + '\'' +
                ", userName='" + userName + '\'' +
                ", userTier='" + userTier + '\'' +
                '}';
    }
}
