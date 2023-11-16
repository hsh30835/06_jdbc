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
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("insertMenu"));

            System.out.println("메뉴 이름입력: ");
            String menu = scanner.nextLine();
            pstmt.setString(1,menu);
            System.out.println("가격");
            int price = scanner.nextInt();
            pstmt.setInt(2,price);
            System.out.println("카테");
            int category = scanner.nextInt();
            pstmt.setInt(3,category);
            scanner.nextLine();
            System.out.println("sta");
            String status = scanner.nextLine();
            pstmt.setString(4,status);


            result = pstmt.executeUpdate();
            System.out.println(result);
            if(result==1){
                System.out.println("성공");
            }else{
                System.out.println("실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }
    }
}
