package com.ohgiraffers.opez.service;
import com.ohgiraffers.opez.model.dao.OpDAO;
import com.ohgiraffers.opez.model.vo.OpVO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.opez.common.JDBCTemplate.*;
public class OpService {
    private OpDAO opDAO;

    public OpService(String url) {
        this.opDAO = new OpDAO(url);
    }

    public List<OpVO> findUser(){
        Connection con = getConnection();
        List<OpVO> list = opDAO.findAllUser(con);
        close(con);
        return list;
    }
}
