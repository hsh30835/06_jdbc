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
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();
        int result = 0;

        try {
            //불러올 파일경로 지정
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            //update쿼리문 사용
            pstmt=con.prepareStatement(prop.getProperty("update"));

            //수정할 메뉴이름 입력
            System.out.println("수정할 메뉴 이름 : ");
            String menuName = scanner.nextLine();
            pstmt.setString(5,menuName);
            //변경할 메뉴이름 입력
            System.out.println("변경할 메뉴 이름 : ");
            String changeName = scanner.nextLine();
            pstmt.setString(1,changeName);
            //변경할 가격 입력
            System.out.println("변경할 가격 : ");
            int price = scanner.nextInt();
            pstmt.setInt(2,price);
            //변경할 카테고리 입력
            System.out.println("변경할 카테고리 : ");
            int category = scanner.nextInt();
            pstmt.setInt(3,category);
            //묻히는 현상때매 nextLine 한번 더 써줌
            scanner.nextLine();
            //변경할 스테이터스 입력
            System.out.println("변경할 스테이터스 : ");
            String status = scanner.nextLine();
            pstmt.setString(4,status);

            result = pstmt.executeUpdate();
            System.out.println(result);
            if(result==1){
                System.out.println("수정 완료");
            }else{
                System.out.println("수정 실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(pstmt);
        }
    }
}
