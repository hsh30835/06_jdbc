package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application03 {
    public static void main(String[] args){
        Connection con = getConnection(); //연결
        Statement stmt = null; //stmt를 초기화
        ResultSet rset = null; //rset을 초기화
        Scanner scanner = new Scanner(System.in); //문자열 입력
        try {
            stmt = con.createStatement(); //Statement를 생성하고 연결한다
            System.out.println("조회하고자 하는 이름을 입력해주세요");
            String empName = scanner.nextLine();
            String query= "SElECT " + // 쿼리만들기
                            "EMP_ID, " +
                            "EMP_NAME" +
                            " FROM EMPLOYEE" +
                            " WHERE EMP_NAME = '" + empName + "'";
            rset = stmt.executeQuery(query); // 쿼리 실행하기
            while(rset.next()){ //반복조건 : rset의 다음이 있다면
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
            } //EMP_ID와 EMP_NAME의 결과를 출력
        } catch (SQLException e) { //SQLExcpetion 에러가 뜰시
            e.printStackTrace(); // 무시하고 강행
        }finally { //마지막에 무조건 실행됨
            close(con);
            close(stmt);
            close(rset);
            scanner.close();
        }
    }
}
