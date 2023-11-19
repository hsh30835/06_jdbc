package com.ohgiraffers.restaurant.model.delete;

public class MenuDelete {
    private String menuName;

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
