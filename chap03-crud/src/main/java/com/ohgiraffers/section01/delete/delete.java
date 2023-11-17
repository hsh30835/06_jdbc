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
        Connection con = getConnection();
        Scanner scanner = new Scanner(System.in);
        Properties prop = new Properties();
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            //경로지정
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            //연결
            pstmt=con.prepareStatement(prop.getProperty("delete"));
            //삭제할 메뉴이름 입력
            System.out.println("삭제할 메뉴이름 입력");
            String menuName = scanner.nextLine();
            pstmt.setString(1,menuName);
            //삭제가 됐는지 확인
            result = pstmt.executeUpdate();
            if(result==1){
                System.out.println("삭제 완료");
            }else{
                System.out.println("삭제 실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally { //닫기
            close(con);
            close(pstmt);
        }
    }
}
