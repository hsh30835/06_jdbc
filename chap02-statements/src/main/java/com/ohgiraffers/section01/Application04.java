package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.Employee2DTO;
import com.ohgiraffers.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.service.App4Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application04 {
    public static void main(String[] args){
        /*
        * 객체(object)는 사전적인 정의로 실제 존재하는 것을 말한다.
        * 붕어빵틀 붕어빵 = new 붕어빵틀();
        * 붕어빵틀에선 붕어빵틀이 나옴 붕어빵이 안나옴
        * 사람 김연아 = new 사람();
        * 사람이라는 공통적 특성에서 김연아가 존재할 수 있음
        *
        * 개체 : 생물학에서의 개체(個體)는 하나의 생물체를 뜻한다
        * 클래스 안에 인스턴스를 만들어야하는데 그 인스턴스가 개체다
        *
        * 사람 손연재 = new 사람(); <- 인스턴스
        * 사람 이준효 = new 사람(); <- 인스턴스
        * 결혼하다(사람 누구?); 사람은 사람이랑 결혼하니깐 누구?에 사람이 들어가야됨
        * 손연재.결혼(이준효)
        *
        * 아래의 정답 중 개체를 골라주세요
        * 1.쥐
        * 2.미키마우스
        * 3.제리
        * 4.사람
        * 5.손연재
        * 정답 : 235
        * */

        /*
        * 200
        * 선동일
        * 621235-1985634
        * sun_di@greedy.com
        * 01099546325
        * D9
        * J1
        * S1
        * 8000000
        * 0.3
        * 1990-02-06
        * N
        * */
        //기본 생성시
//        Employee2DTO nonBuilder = new Employee2DTO();
//        nonBuilder.setEmpId("200");
//        nonBuilder.setEmpName("선동일");
//
//        EmployeeDTO builderEmp = new EmployeeDTO().setEmpNo("621235-1985634")
//                .setBonus(0.3)
//                .setEmpid("200")
//                .setJopCode("j1");
//        System.out.println(builderEmp);
        Connection con = getConnection();
        App4Service service = new App4Service();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해주세요 : ");
        String empId = scanner.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId+"'";
//        System.out.println(query);
        EmployeeDTO emp = null; //EmployeeDTO의 emp를 초기화 시킨다
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()){ //조건을 성립하면 실행 if문은 단 하나만을 찾을땐 효율적이다
                emp = new EmployeeDTO() //emp를 선언
                        .setEmpNo(rset.getString("EMP_NO"))
                        .setEmpid(rset.getString("EMP_ID"))
                        .setName(rset.getString("EMP_NAME"))
                        .setEmail(rset.getString("EMAIL"))
                        .setPhone(rset.getString("PHONE"));
                //해당하는 결과는 불러옴
            }
            service.printEmployee(rset);
            service.print(emp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
