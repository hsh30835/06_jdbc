package com.ohgiraffers.restaurant.service;

import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVo;
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

public class MenuService {
    private MenuDAO menuDAO;

    public MenuService(String url) {
        this.menuDAO = new MenuDAO(url);
    }

    public List<MenuVo> findMenu(){
        // DB 연결
        Connection con = getConnection();
        // 비즈니스 로직 ex) price > 0
        List<MenuVo> list = menuDAO.findAllMenu(con);

        close(con);
        return list;

    }

    public int registMenu(MenuDTO menuDTO) { //등록에 대한 조건
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        if(!category.contains(menuDTO.getCategory())){
            return 0;
        }
        if(menuDTO.getPrice() <= 1000){
            return 0;
        }
        int result = menuDAO.registMenu(con, menuDTO);

        close(con);

        return result;
    }
}
