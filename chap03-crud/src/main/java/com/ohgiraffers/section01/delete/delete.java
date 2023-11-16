package com.ohgiraffers.section01.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import static com.ohgiraffers.common.JDBCTemplate.*;
public class delete {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        int result = 0;

        try {
            //불러올 파일 경로 지정하기
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            //불러오기
            pstmt = con.prepareStatement(prop.getProperty("delete"));
            //삭제할 메뉴 이름 입력하기
            System.out.println("삭제할 메뉴 이름");
            String menuName = scanner.nextLine();
            pstmt.setString(1,menuName);
            //삭제 완료시 삭제완료 아닐시 삭제실패출력
            result = pstmt.executeUpdate();
            if(result==1){
                System.out.println("삭제 완료");
            }else {
                System.out.println("삭제 실패");
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
