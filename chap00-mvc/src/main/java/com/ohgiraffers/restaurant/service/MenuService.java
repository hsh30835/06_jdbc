package com.ohgiraffers.restaurant.service;

import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.delete.MenuDelete;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.update.MenuUpdate;
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

    public int modifyMenu(MenuUpdate menuUpdate){
        Connection con = getConnection();
        List<String> category = menuDAO.findAllCategoryCode(con);

        if(!category.contains(menuUpdate.getCategory())){
            return 0;
        }
        if(menuUpdate.getPrice() <= 1000){
            return 0;
        }
        int result = menuDAO.modifyMenu(con, menuUpdate);

        close(con);

        return result;
    }

    public int deleteMenu(MenuDelete menuDelete){
        Connection con = getConnection();
        List<String> menuName = menuDAO.findAllMenuName(con);

        if(!menuName.contains(menuDelete.getMenuName())){
            return 0;
        }
        int result = menuDAO.deleteMenu(con, menuDelete);

        close(con);

        return result;
    }
}
