package com.ohgiraffers.restaurant.model.dao;

import com.ohgiraffers.restaurant.model.delete.MenuDelete;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.update.MenuUpdate;
import com.ohgiraffers.restaurant.model.vo.MenuVo;
import static com.ohgiraffers.restaurant.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MenuDAO {
    Properties prop = new Properties();

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MenuVo> findAllMenu(Connection con) { //findAllMenu에 연결한다
        Statement stmt = null; //stmt의 값을 초기화
        ResultSet rset = null; //rset의 값을 초기화
        List<MenuVo> resultList = new ArrayList<>(); //MenuVo의 리스트를 만든다
        try {
            stmt = con.createStatement(); //Statement를 만들고 연결한다
            rset = stmt.executeQuery(prop.getProperty("findAllMenu")); //findAllMenu 쿼리를 받아온다
            //while문을 쓴이유 : 데이터가 몇갠지 몰라서
            while (rset.next()) { //rset에 다음이 있다면
                resultList.add(new MenuVo(rset.getInt(1), //1번컬럼명에 해당하는 값 입력
                        rset.getString(2), //2번컬럼명에 해당하는 값 입력
                        rset.getInt(3), //3번컬럼명에 해당하는 값 입력
                        rset.getString(4), //4번컬럼명에 해당하는 값 입력
                        rset.getString(5))); //5번컬럼명에 해당하는 값 입력
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }
        return resultList;
    }

    /**
     * 카테고리 코드가 존재하는지 확인한다.
     * @param con Connection
     * @return List<Integer>
     * */
    public List<String> findAllCategoryCode(Connection con) {
        //카테고리코드를 만든이유는 카테고리코드를 비교해서 맞으면 실행되고 틀리면 실행이안됨?
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllCategory"));

            while (rset.next()) {
                resultList.add(rset.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }
        return resultList;
    }

    public List<String> findAllMenuName(Connection con) {
        //내가 findAllMenuName을 만든이유는 delete에서 menuName만 만들어서
        //비교할 카테고리코드 대상이 없어서 비교대상으로 findAllMenuName을 만듬
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllMenuName"));

            while (rset.next()) {
                resultList.add(rset.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }
        return resultList;
    }

    public int registMenu(Connection con, MenuDTO menuDTO) { //메뉴 등록
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("insertMenu"));
            stmt.setString(1,menuDTO.getMenuName());
            stmt.setInt(2,menuDTO.getPrice());
            stmt.setString(3, menuDTO.getCategory());
            stmt.setString(4, menuDTO.getStatus());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }

    public int modifyMenu(Connection con, MenuUpdate menuUpdate) { //메뉴 수정
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("update"));
            stmt.setString(5,menuUpdate.getChangeName());
            //5번부터 넣은 이유는 update 쿼리문에서 해당 이름이 같은 조건을 넣어서
            stmt.setString(1,menuUpdate.getMenuName());
            stmt.setInt(2,menuUpdate.getPrice());
            stmt.setString(3, menuUpdate.getCategory());
            stmt.setString(4, menuUpdate.getStatus());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }

    public int deleteMenu(Connection con, MenuDelete menuDelete){
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("delete"));
            stmt.setString(1,menuDelete.getMenuName());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }
}
