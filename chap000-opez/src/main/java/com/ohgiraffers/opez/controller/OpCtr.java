package com.ohgiraffers.opez.controller;

import com.ohgiraffers.opez.model.delete.OpDelete;
import com.ohgiraffers.opez.model.dto.OpDTO;
import com.ohgiraffers.opez.model.update.OpUpdate;
import com.ohgiraffers.opez.model.vo.OpVO;
import com.ohgiraffers.opez.service.OpService;

import java.util.List;
import java.util.Objects;

public class OpCtr {
    private OpService opService;

    public OpCtr(OpService opService) {
        this.opService = opService;
    }

    public List<OpVO> findAllUser(){
        List<OpVO> list = opService.findUser();

        if(Objects.isNull(list)){
            return null;
        }
        return list;
    }
    public String modifyUser(OpUpdate opUpdate){ //수정
        if(Objects.isNull(opUpdate)){ // 정보자체가 없을 시
            return "정보가 존재하지 않아 입력해야됨";
        }
        if(opUpdate.getChangeName()==null || opUpdate.getChangeName().equals("")){ // 메뉴이름을 아예 안적을시
            return "메뉴이름 등록";
        }

        int result = opService.modifyMenu(opUpdate);

        if(result<=0){
            return "수정중 오류가 발생됨";
        }else {
            return "수정완료";
        }
    }

    public String registUser(OpDTO opDTO){ //등록
        if(Objects.isNull(opDTO)){
            return "유저 정보가 존재하지 않아요 입력좀 해주세요";
        }
        if(opDTO.getUserName()==null || opDTO.getUserName().equals("")){
            return "유저 이름을 등록해주세요";
        }

        // 유효성 검사가 끝난 메뉴
        int result = opService.registUser(opDTO);

        if(result<=0){
            return "등록중 오류가 발생됨";
        }else {
            return "등록완료";
        }
    }

    public String deleteUser(OpDelete opDelete){ //삭제
        if(Objects.isNull(opDelete)){
            return "정보가 존재하지 않아 입력해야됨";
        }
        if(opDelete.getUserName()==null || opDelete.getUserName().equals("")){
            return "유저이름 등록";
        }
        int result = opService.deleteMenu(opDelete);
        //System.out.println(result); 결과값이 들어가면 숫자가 나오고 아니면 0

        if(result<=0){
            return "삭제중 오류가 발생됨";
        }else {
            return "삭제완료";
        }
    }
}
