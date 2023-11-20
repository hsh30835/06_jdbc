package com.ohgiraffers.opez.model.dao;
import com.ohgiraffers.opez.model.delete.OpDelete;
import com.ohgiraffers.opez.model.dto.OpDTO;
import com.ohgiraffers.opez.model.update.OpUpdate;
import com.ohgiraffers.opez.model.vo.OpVO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.opez.common.JDBCTemplate.*;

public class OpDAO {
    Properties prop = new Properties();

    public OpDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<OpVO> findAllUser(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<OpVO> resultList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllUser"));

            while(rset.next()){
                resultList.add(new OpVO(rset.getInt(1),
                        rset.getString(2),
                        rset.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(stmt);
        }
        return resultList;
    }
    public List<String> findAllUserName(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<String> resultList = new ArrayList<>();
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(prop.getProperty("findAllUserName"));

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

    public int registUser(Connection con, OpDTO opDTO) { //메뉴 등록
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("insertUser"));
            stmt.setString(1,opDTO.getUserName());
            stmt.setString(2,opDTO.getUserTier());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }

    public int modifyUser(Connection con, OpUpdate opUpdate) { //메뉴 수정
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("updateUser"));
            stmt.setString(3,opUpdate.getChangeName());
            stmt.setString(1,opUpdate.getUserName());
            stmt.setString(2,opUpdate.getUserTier());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }

    public int deleteUser(Connection con, OpDelete opDelete){
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int result = 0;
        try {
            stmt = con.prepareStatement(prop.getProperty("deleteUser"));
            stmt.setString(1,opDelete.getUserName());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
        }
        return result;
    }
}
