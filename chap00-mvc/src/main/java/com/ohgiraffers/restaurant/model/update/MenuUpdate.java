package com.ohgiraffers.restaurant.model.update;

public class MenuUpdate {
    private String changeName; // 수정할 대상의 이름
    private String menuName;
    private int price;
    private String category;
    private String status;

    public MenuUpdate() {
    }

    public MenuUpdate(String changeName, String menuName, int price, String category, String status) {
        this.changeName = changeName;
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public MenuUpdate(String url) {
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
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
        return "MenuUpdate{" +
                "changeName='" + changeName + '\'' +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
