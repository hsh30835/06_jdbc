package com.ohgiraffers.section01.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application03 {
    public static void main(String[] args){
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            System.out.println("직급이 부장인 사람의 이름, 전화번호를 출력하세요");
            String query = "SELECT " +
                    "EM.EMP_NAME, " +
                    "EM.PHONE" +
                    " FROM EMPLOYEE AS EM JOIN JOB AS J ON EM.JOB_CODE=J.JOB_CODE" +
                    " WHERE J.JOB_NAME = '부장'";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                System.out.println(rset.getString("EM.EMP_NAME") + " " + rset.getString("EM.PHONE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
