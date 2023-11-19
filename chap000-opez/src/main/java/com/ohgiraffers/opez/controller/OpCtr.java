package com.ohgiraffers.opez.controller;

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
}
