package com.ohgiraffers.section01.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            System.out.println("선동일 사원의 사번, 이름, 연락처, 직급 출력");
            String query= "SElECT " +
                    "EM.EMP_ID, " +
                    "EM.EMP_NAME, " +
                    "EM.PHONE, " +
                    "J.JOB_NAME" +
                    " FROM EMPLOYEE AS EM JOIN JOB AS J ON EM.JOB_CODE=J.JOB_CODE" +
                    " WHERE EMP_NAME = '선동일'";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                System.out.println(rset.getString("EM.EMP_ID") + " " + rset.getString("EM.EMP_NAME")
                + " " +rset.getString("EM.PHONE") + " " + rset.getString("J.JOB_NAME"));
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
