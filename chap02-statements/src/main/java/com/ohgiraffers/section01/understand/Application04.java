package com.ohgiraffers.section01.understand;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application04 {
    public static void main(String[] args){
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            System.out.println("employee 테이블에서 보너스가 있는사람의 이름과 보너스가격 출력");
            String query = "SELECT " +
                            "EMP_NAME," +
                            "SALARY * BONUS" +
                            " FROM EMPLOYEE" +
                            " WHERE BONUS IS NOT NULL";
            rset = stmt.executeQuery(query);
            while (rset.next()){
                System.out.println(rset.getString("EMP_NAME")
                        +" "+rset.getString("SALARY * BONUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
