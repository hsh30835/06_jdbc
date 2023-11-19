package com.ohgiraffers.opez.model.vo;

public class OpVO {
        private int userNumber;
        private String userName;
        private String userTier;

        public OpVO() {
        }

        public OpVO(int userNumber, String userName, String userTier) {
            this.userNumber = userNumber;
            this.userName = userName;
            this.userTier = userTier;
        }

        public int getUserNumber() {
            return userNumber;
        }

        public void setUserNumber(int userNumber) {
            this.userNumber = userNumber;
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
            return "OpVO{" +
                    "userNumber=" + userNumber +
                    ", userName='" + userName + '\'' +
                    ", userTier='" + userTier + '\'' +
                    '}';
        }
    }

