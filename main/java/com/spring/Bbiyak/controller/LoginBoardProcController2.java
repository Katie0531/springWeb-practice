package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

import javax.servlet.http.HttpSession;


public class LoginBoardProcController2 implements Controller {

    private BoardDao boardDao;
    

    // BoardDao�� �����ڳ� ���� �޼��带 ���� ����
    public LoginBoardProcController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("InsertBoardProcController --> ");

        // 1. ������ �������� (request)
        String password = request.getParameter("password");
        String id = request.getParameter("id");

        // 2. �����ͺ��̽����� ����� ���� Ȯ��
        boolean isValidUser = boardDao.isValidUser(id, password);

        // 3. ����� ���� ������ �̵�
        if (isValidUser) {
            // ����ڰ� ��ȿ�ϸ� 
            ModelAndView mav = new ModelAndView("mainBoardView"); 

            return mav;
        } else {
            // ����ڰ� ��ȿ���� ������ 
            ModelAndView mav = new ModelAndView("insertBoardView"); 
            return mav;
        }
    }
}
