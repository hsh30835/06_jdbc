package com.ohgiraffers.section01.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection(); // con의 이름을 가진 Connection을 연결한다
        Statement stmt = null; // stmt의 이름을 가진 Statement 값을 null로 준다
        ResultSet rset = null; // rset의 이름을 가진 ResultSet의 값을 null로 준다
        //Connection = 연결, Statement = 실행, ResultSet = 결과

        try {
            stmt = con.createStatement(); //con의 Statement를 만들어준다
            System.out.println("employee 테이블에서 급여를 가장 많이 받는 사원의 사번, 이름, 전화번호를 출력하세요");
            String query= "SElECT " +
                    "EMP_ID, " +
                    "EMP_NAME, " +
                    "PHONE " +
                    " FROM EMPLOYEE" +
                    " SALARY LIMIT 1";
            rset = stmt.executeQuery(query); // query를 실행시킨다
            while(rset.next()){ // 조건 : rset의 다음이 있을때
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME")
                        + " " +rset.getString("PHONE"));
            } //EMP_ID, EMP_NAME, PHONE의 값을 출력한다
        } catch (SQLException e) { // SQLException 오류가 뜰시
            e.printStackTrace(); // 무시하고 실행한다
        }finally { // 마지막에 무조건 실행
            close(con); // con을 닫는다
            close(stmt); // stmt를 닫는다
            close(rset); // rset을 닫는다
        }
    }
}
