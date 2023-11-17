package com.ohgiraffers.section01.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Update {
    public static void main(String[] args){
        Connection con = getConnection();
        PreparedStatement pstmp = null;
        Properties prop = new Properties();
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        try {
            //경로지정
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            //연결
            pstmp=con.prepareStatement(prop.getProperty("update"));
            //수정할 이름 입력하기
            System.out.println("수정할 메뉴 이름 입력 : ");
            String menuName = scanner.nextLine();
            pstmp.setString(5,menuName);
            //바꿀 이름 입력하기
            System.out.println("메뉴 이름 변경 : ");
            String chageName = scanner.nextLine();
            pstmp.setString(1,chageName);
            //바꿀 가격 입력하기
            System.out.println("가격 변경 : ");
            int price = scanner.nextInt();
            pstmp.setInt(2,price);
            //바꿀 카테고리코드 입력하기
            System.out.println("카테고리 변경");
            int category = scanner.nextInt();
            pstmp.setInt(3,category);
            //마지막 출력이 묻혀서 nextLine()한번 더 써줌
            scanner.nextLine();
            //바꿀 스테이터스 입력하기
            System.out.println("스테이터스 변경");
            String status = scanner.nextLine();
            pstmp.setString(4,status);
            //성공과 실패여부 확인하기
            result = pstmp.executeUpdate();
            if(result==1){
                System.out.println("수정 성공");
            }else{
                System.out.println("수정 실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally { //닫기
            close(con);
            close(pstmp);
        }
    }
}
