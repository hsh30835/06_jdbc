package com.ohgiraffers.opez.view;

import com.ohgiraffers.opez.controller.OpCtr;
import com.ohgiraffers.opez.model.vo.OpVO;
import com.ohgiraffers.opez.service.OpService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OpView {
    public static void runApplication(){
        Scanner scanner = new Scanner(System.in);
        OpCtr menuCtr = new OpCtr(new OpService("src/main/resources/mapper/menu-query.xml")); //url경로를 넣어준다
        프로그램 : while(true){
            System.out.println("메뉴관리 프로그램입니다.");
            System.out.println(" 1. 조회 \n 2. 수정 \n 3. 등록 \n 4. 삭제");
            System.out.println("원하는 기능 입력 : ");
            int step = scanner.nextInt();
            switch (step){
                case 1 : viewOp(menuCtr.findAllUser());
                    break;
                case 2 : break;
                case 3 : break;
                case 4 : break;
                default: break 프로그램;
            }
        }
    }

    public static void viewOp(List<OpVO> opList){
        if(Objects.isNull(opList)) {
            System.out.println("조회중 오류가 발생됨");
        }else if(opList.size()<0) {
            System.out.println("등록된 메뉴 없음");
        }else{
            for(OpVO op:opList){
                System.out.println(op);
            }
        }
    }
}
