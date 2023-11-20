package com.ohgiraffers.opez.service;
import com.ohgiraffers.opez.model.dao.OpDAO;
import com.ohgiraffers.opez.model.delete.OpDelete;
import com.ohgiraffers.opez.model.dto.OpDTO;
import com.ohgiraffers.opez.model.update.OpUpdate;
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

    public int modifyMenu(OpUpdate opUpdate){ // 수정
        Connection con = getConnection();
        List<String> userName = opDAO.findAllUserName(con);

        if(!userName.contains(opUpdate.getUserName())){
            return 0;
        }

        int result = opDAO.modifyUser(con, opUpdate);

        close(con);

        return result;
    }

    public int registUser(OpDTO opDTO) { //등록에 대한 조건
        Connection con = getConnection();
        List<String> userName = opDAO.findAllUserName(con);

        if(!userName.contains(opDTO.getUserName())){
            return 0;
        }

        int result = opDAO.registUser(con, opDTO);

        close(con);

        return result;
    }

    public int deleteMenu(OpDelete opDelete){ //삭제
        Connection con = getConnection();
        List<String> menuName = opDAO.findAllUserName(con);

        if(!menuName.contains(opDelete.getUserName())){
            return 0;
        }
        int result = opDAO.deleteUser(con, opDelete);

        close(con);

        return result;
    }
}
