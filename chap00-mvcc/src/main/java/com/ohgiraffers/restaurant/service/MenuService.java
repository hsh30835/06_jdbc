package com.ohgiraffers.restaurant.service;

import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVO;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import static com.ohgiraffers.restaurant.common.JDBCTemplate.*; //JDBCTemplate에 있는 모든 기능을 쓰겠다

public class MenuService {
    //MenuService는 버튼을 눌러서 티비랑 상호작용하는 것

    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public List<MenuVO> findMenu(){
        // DB연결
        Connection con = getConnection();
        // 비즈니스 로직 ex) price > 0
        List<MenuVO> list = menuDAO.findAllMenu(con);
        //menuDAO에서 finAllMenu를 con에 넘긴 다음에 받는것
        close(con);
        return list;
    }

    public int registMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        //카테고리 코드 리스트에 지금 현재 사용자가 입력한 카테고리코드가 있지 않다면
        if(!category.contains(menuDTO.getCategory())){
            return 0;
        }
        if(menuDTO.getPrice() <= 1000){
            return 0;
        }
        int result = menuDAO.registMenu(con, menuDTO); //con과 menuDTO를 전달할것

        close(con);

        return result;
    }
}
