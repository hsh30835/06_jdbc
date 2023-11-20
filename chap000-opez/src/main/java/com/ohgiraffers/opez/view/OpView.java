package com.ohgiraffers.opez.view;

import com.ohgiraffers.opez.controller.OpCtr;
import com.ohgiraffers.opez.model.delete.OpDelete;
import com.ohgiraffers.opez.model.dto.OpDTO;
import com.ohgiraffers.opez.model.update.OpUpdate;
import com.ohgiraffers.opez.model.vo.OpVO;
import com.ohgiraffers.opez.service.OpService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OpView {
    public static void runApplication(){
        Scanner scanner = new Scanner(System.in);
        OpCtr opCtr = new OpCtr(new OpService("src/main/resources/mapper/menu-query.xml")); //url경로를 넣어준다
        프로그램 : while(true){
            System.out.println("유저관리 프로그램입니다.");
            System.out.println(" 1. 조회 \n 2. 수정 \n 3. 등록 \n 4. 삭제");
            System.out.println("원하는 기능 입력 : ");
            int step = scanner.nextInt();
            switch (step){
                case 1 : viewUser(opCtr.findAllUser());
                    break;
                case 2 :
                    System.out.println(opCtr.modifyUser(modifyMenu()));
                    break;
                case 3 :
                    System.out.println(opCtr.registUser(registUser()));
                    break;
                case 4 :
                    System.out.println(opCtr.deleteUser(deleteUser()));
                    break;
                default: break 프로그램;
            }
        }
    }

    public static void viewUser(List<OpVO> opList){ //유저 조회하기
        if(Objects.isNull(opList)){
            System.out.println("조회중 오류가 발생됨");
        }else if(opList.size() < 0){
            System.out.println("등록된 유저가 없네요");
        }else {
            for (OpVO menuVo:opList){
                System.out.println(menuVo);
            }
        }
    }

    public static OpUpdate modifyMenu(){ //유저 수정하기
        OpUpdate opUpdate = new OpUpdate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================");
        System.out.println();
        System.out.print("수정하고 싶은 유저 이름을 입력 : ");
        opUpdate.setChangeName(scanner.nextLine()); //수정할 메뉴 이름을 입력하기
        System.out.println("변경할 이름 입력 : ");
        opUpdate.setUserName(scanner.nextLine());
        System.out.println("변경할 티어 입력 : ");
        opUpdate.setUserTier(scanner.nextLine());

        return opUpdate;
    }
    public static OpDTO registUser(){ //유저 등록하기
        OpDTO newUser = new OpDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println();
        System.out.print("등록할 유저 이름을 입력해주세요 : ");
        newUser.setUserName(sc.nextLine());
        System.out.print("티어를 입력해주세요 : ");
        newUser.setUserTier(sc.nextLine());

        return newUser;
    }
    public static OpDelete deleteUser(){ //유저 삭제하기
        OpDelete opDelete = new OpDelete();
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================");
        System.out.println();
        System.out.print("삭제할 유저 이름 입력 : ");
        opDelete.setUserName(scanner.nextLine()); //메뉴이름만 입력해도 삭제하기

        return opDelete;
    }

}
