package com.ohgiraffers.restaurant.model.dto;

public class MenuDTO { //메뉴 등록에 대한 정보를 가짐
    //MenuDTO랑 MenuVo랑 비슷한거 같은데 다르게 한이유
    //ID를 auto increment로 줬기때문에 안받는게 더 좋음
    //계층마다 데이터 옮길때쓰는게 dto인데 등록 수정 삭제 다 할 수 있음
    //MenuVO는 보여주기 용이고 MenuDTO는 값을 입력하는 용도인데
    //만약 둘이 같이 썼다가 VO에서 지워줘야 하는일이 생기면 DTO도 따라 지워서야되서 에러가 발생한다
    private String menuName;
    private int price;
    private String category;
    private String status;

    public MenuDTO() {
    }

    public MenuDTO(String menuName, int price, String category, String status) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
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
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
