package com.ohgiraffers.restaurant.model.vo;

public class MenuVo { //VO는 vlaue object //사용자측에 데이터를 전달해줄려고 쓰는거
    private int menuCode; //int 타입의 menuCode 생성
    private String menuName; //String 타입의 menuName 생성
    private int price; //int 타입의 price 생성
    private String category; //String 타입의 category 생성
    private String status; //String 타입의 status 생성

    public MenuVo() {
    }

    public MenuVo(int menuCode, String menuName, int price, String category, String status) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuVo{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
