package com.ohgiraffers.restaurant.view;

import com.ohgiraffers.restaurant.controller.MenuCtr;
import com.ohgiraffers.restaurant.model.dao.MenuDAO;
import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVO;
import com.ohgiraffers.restaurant.service.MenuService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    /*
    * view 계층을 예시로 만듬
    * 이후 해당 페이지는 html로 변경된다.
    * */
    public static void runApplication(){
        //1. 사용자가 원하는 기능을 선택함
        //2. 기능에 따라 동작됨
        Scanner scanner = new Scanner(System.in); //사용자가 입력할 수 있도록 함
        //메뉴 조회 만들기
        MenuCtr menuCtr = new MenuCtr(new MenuService("src/main/resources/mapper/menu-query.xml")); //url경로를 넣어준다
        //1. MenuService 클래스의 새로운 인스턴스를 생성한다.
        //2. 이렇게 생선된 MenuService인스턴스를 이용하여 MenuCtr 클래스의 객체를 생성한다.
        //3. 생성된 MenuCtr객체는 menuCtr 변수에 할당된다

        //while문을 거는 이유는 사용자가 입력하고 취소해버리면 ex) 뒤로가기 앱이 바로 종료가 되므로 무한반복 하기위해 써줌
        프로그램 : while(true){ //루프 건거임
            System.out.println("메뉴관리 프로그램입니다.");
            System.out.println(" 1. 조회 \n 2. 수정 \n 3. 등록 \n 4. 삭제");
            System.out.println("원하는 기능 입력 : ");
            //작동하는 순서 1.여기서 사용자가 원하는 값을 넣어줌
            //1.사용자가 입력한 페이지로 값을 이동한다
            int step = scanner.nextInt();
            //2.기능에 따라 동작됨
            //타입이 명확해서 switch가 더 좋음
            switch (step){
                //2-1 : 메뉴 조회
                case 1 : viewMenu(menuCtr.findAllMenu()); //페이지를 다른쪽으로 전달해서 받을거
                    //작동하는 순서 2. menuCtr.findAllMenu(); 이 메서드를 호출한다
                    //작동하는 순서 4. 반환된 데이터를 받을건데 여기서 받을놈을 만든다
                break;
                //2-2 : 메뉴 수정
                case 2 : break;
                //2-3 : 메뉴 등록
                case 3 :
                    System.out.println(menuCtr.registMenu(registMenu())); break;
                //2-4 : 메뉴 삭제
                case 4 : break;
                //default : 프로그램 종료
                default: break 프로그램; // 스위치문에는 return이나 루프로 종료시킴
            }


        }

    }
    //List<>는 목록형태의 데이터를 다루기 위한 자료구조로 사용한다 여러개의 항목을 하나의 자료구조로 관리할 수 있다
    public static void viewMenu(List<MenuVO> menuList){
        //viewMenu를 스태틱으로 만든이유 : 스태틱으로 만들지 않으면 위에가 먼저 실행되고 여기로 내려오는데 생명주기가 맞지 않음
        //isEmpty는 리스트가 비어있으면 true를 반환하고 그렇지 않으면 false를 반환한다
        if(Objects.isNull(menuList)) { //조회했는데 에러난 경우
            //Objects.isNull(menuList)은 menuList가 null일 경우 true 아닐시 false를 반환한다
            //그래서 null이 나오면 조회중 오류가 발생함이 출력되고 아닐시 else if로 내려간다
            System.out.println("조회중 오류가 발생됨");
        }else if(menuList.size()<0) { // 등록된 메뉴가 없을시
            System.out.println("등록된 메뉴 없음");
        }else{
            for(MenuVO menu:menuList){ //메뉴가 보여지는 페이지
                System.out.println(menu);
            }
        }
    }
    public static MenuDTO registMenu(){
        MenuDTO newMenu = new MenuDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println();
        System.out.print("등록할 메뉴 이름을 입력해주세요 : ");
        newMenu.setMenuName(sc.nextLine());
        System.out.println("가격을 입력해주세요 : ");
        newMenu.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println("카테고리 코드를 입력해주세요 : ");
        newMenu.setCategory(sc.nextLine());
        System.out.println("판매여부를 입력해주세요 : ");
        newMenu.setStatus(sc.nextLine());

        //1차적으로 유효성 검사를 함
        return newMenu;
    }
}
