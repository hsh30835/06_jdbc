package com.ohgiraffers.restaurant.model.delete;

public class MenuDelete { // 메뉴삭제
    private String menuName; // 이름만 맞으면 삭제해도되서 다른걸 안넣어도됨

    public MenuDelete() {
    }

    public MenuDelete(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "MenuDelete{" +
                "menuName='" + menuName + '\'' +
                '}';
    }
}
