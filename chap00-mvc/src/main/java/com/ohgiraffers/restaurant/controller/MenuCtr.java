package com.ohgiraffers.restaurant.controller;

import com.ohgiraffers.restaurant.model.dto.MenuDTO;
import com.ohgiraffers.restaurant.model.vo.MenuVo;
import com.ohgiraffers.restaurant.service.MenuService;

import java.util.List;
import java.util.Objects;

/*
* 사용자의 요청을 받아
* 유효성 체크를 하고 요청을 service로 전달하고
* 이후 service의 반환 값을 페이지로 반환한다.
* */
public class MenuCtr {
    private MenuService menuService;
    public MenuCtr(MenuService menuService){
        this.menuService = menuService;
    }
    public List<MenuVo> findAllMenu(){ //조회
        // 값을 확인한다.
        List<MenuVo> list = menuService.findMenu();

        // 반환값 확인 후 응답 값을 지정
        if(Objects.isNull(list)){
            return null;
        }
        return list;
    }

    public int modifyMenu(int code){ //수정
        System.out.println("modify code : " + code);
        return 0;
    }

    public String registMenu(MenuDTO menuDTO){ //등록
        if(Objects.isNull(menuDTO)){
            return "메뉴 정보가 존재하지 않아요 입력좀 해주세요";
        }
        if(menuDTO.getMenuName()==null || menuDTO.getMenuName().equals("")){
           return "메뉴 이름을 등록해주세요";
        }
        if(menuDTO.getPrice() <= 0){
            return "메뉴가격은 음수일 수 없습니다.";
        }
        if(menuDTO.getCategory()==null || menuDTO.getCategory().equals("")){
            return "카테고리는 필수!";
        }
        if(menuDTO.getStatus()==null || menuDTO.getStatus().equals("")){
            return "판매여부 등록해요";
        }
        // 유효성 검사가 끝난 메뉴
        int result = menuService.registMenu(menuDTO);

        if(result<=0){
            return "등록중 오류가 발생됨";
        }else {
            return "등록완료";
        }
    }

    public int deleteMenu(int code){ //삭제
        System.out.println("code : " + code);
        return 0;
    }
}
