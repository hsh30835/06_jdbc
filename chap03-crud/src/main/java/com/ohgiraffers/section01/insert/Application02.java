package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {
    public static void main(String[] args) {
        /*
         * 사용자가 메뉴를 등록 할 수 있도록 만들어주세요
         * 등록이 완료되면 메뉴등록 성공 실패하면 다시 등록을 요청해주세요
         * */
        Scanner scanner = new Scanner(System.in);
        Connection con = getConnection();
        Properties prop = new Properties();
        PreparedStatement pstmp = null;
        int result = 0;

        try {
            //경로 지정
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            //연결
            pstmp=con.prepareStatement(prop.getProperty("insertMenu"));
            //메뉴이름입력
            System.out.println("메뉴 이름입력: ");
            String menuName = scanner.nextLine();
            pstmp.setString(1,menuName);
            //메뉴가격입력
            System.out.println("메뉴 가격 입력 : ");
            int menuPrice = scanner.nextInt();
            pstmp.setInt(2,menuPrice);
            //메뉴카테고리입력
            System.out.println("메뉴 카테고리 입력 : ");
            int category = scanner.nextInt();
            pstmp.setInt(3,category);
            scanner.nextLine();
            //스테이터스 입력
            System.out.println("메뉴 스테이터스 입력 : ");
            String status = scanner.nextLine();
            pstmp.setString(4,status);
            //성공 실패 확인
            result= pstmp.executeUpdate();
            if(result==1){
                System.out.println("메뉴 등록 성공");
            }else{
                System.out.println("메뉴 등록 실패");
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
