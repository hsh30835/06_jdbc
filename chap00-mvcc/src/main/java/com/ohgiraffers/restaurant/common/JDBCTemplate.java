package com.ohgiraffers.restaurant.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection(){
        Properties prop = new Properties();
        Connection con = null; //con의 값을 초기화 한다

        try {
            prop.load(new FileReader("src/main/resources/config/connection-info.properties"));
            //src/main/resources/config/connection-info.properties의 경로에 있는 파일을 불러온다
            //properties와 xml의 문서양식은 달라서 지금은 xml파일을 쓴게아니므로 FileReader을 쓴다
            String driver = prop.getProperty("driver");// driver정보를 가져온다
            String url = prop.getProperty("url");// url정보를 가져온다
            con = DriverManager.getConnection(url,prop); //데이터베이스와의 연결을 수립한다
            } catch (IOException e) { // 연결하는 과정에서 문제가 생길시 RuntimeException을 던진다
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con){ //con 닫기
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){ //stmt 닫기
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){ //rset 닫기
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
