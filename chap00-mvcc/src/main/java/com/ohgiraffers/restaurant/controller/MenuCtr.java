package com.ohgiraffers.restaurant.controller;

import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVO;
import com.ohgiraffers.restaurant.service.MenuService;

import java.util.List;
import java.util.Objects;

/*
* 사용자의 요청을 받아
* 유효성 체크를 하고 요청을 service로 전달하고
* 이후 service의 반환 값을 페이지로 반환한다.
* */
public class MenuCtr {
    //MenuCtr은 리모콘 버튼
    //리스트를 넘길 애를 찾음

    //MenuView에서 사용자가 내린 명령을 처리한다
    private MenuService menuService;

    public MenuCtr(MenuService menuService) { //의존성 주입
        this.menuService = menuService;
    }

    public List<MenuVO> findAllMenu(){ //메뉴 전체를 조회한다
        //작동하는 순서 3. 그럼 얘가 응답함 그뒤로 데이터를 받고 반환한다
        //값을 확인한다 근데 지금 값이 없음
        //System.out.println("메뉴 조회 테스트"); //단계별로 먼저 동작이 되나 확인하고 그 이후로 넘어가는게 나중에 좋음
        //return null; //한번에 만들고 실행한담에 에러가 발생시 에러 찾기가 매우 어려워짐
        List<MenuVO> list = menuService.findMenu();
        //menuService의 findMenu메서드를 호출하여 메뉴정보가 담긴 List<MenuVO)를 얻고 그 정보를 list변수에 할당함

        //반환값 확인 후 응답 값을 지정
        if(Objects.isNull(list)){ //list의 값이 null인 경우엔 null을 반환하고
            return null;
        }
        return list; // 그렇지 않을시 list를 반환한다
        //에러난거랑 값이 없는거랑은 달라서 이렇게 쓴다
    }

    //수정과 삭제를 code로 한 이유는? 아직 만들어 놓기만 한거라 테스트를 위해?
    public int modifyMenu(int code){ //메뉴 수정
        System.out.println("modify code : " + code);
        return 0;
    }

    public String registMenu(MenuDTO menuDTO){ //메뉴 등록
        if(Objects.isNull(menuDTO)){
            System.out.println("메뉴가 없네요");
            return "메뉴 정보가 존재하지 않아요 입력좀 해주세요";
        }
        if(menuDTO.getMenuName() == null || menuDTO.getMenuName().equals("")){ //빈값과 null은 다름
            return "메뉴 이름을 등록";
        }
        if(menuDTO.getPrice() <= 0){
            return "가격은 음수 안됨";
        }
        if (menuDTO.getCategory() == null || menuDTO.getCategory().equals("")){
            return "카테고리는 필수";
        }
        if(menuDTO.getStatus() == null || menuDTO.getStatus().equals("")){
            return "판매여부 등록해요";
        }
        // 유효성 검사가 끝난 메뉴
        int result = menuService.registMenu(menuDTO);

        if(result <= 0){
            return "등록중 오류가 발생됨";
        }else {
            return "등록완료";
        }
    }

    public int deleteMenu(int code){ //메뉴 삭제
        System.out.println("code : " + code);
        return 0;
    }
}
