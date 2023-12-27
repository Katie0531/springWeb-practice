package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;

public class LoginBoardProcController implements Controller {

    private BoardDao boardDao;

    // BoardDao�� �����ڳ� ���� �޼��带 ���� ����
    public LoginBoardProcController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LoginBoardProcController --> ");

        // 1. ������ �������� (request)
        String password = request.getParameter("password");
        String id = request.getParameter("id");

        // 2. �����ͺ��̽����� ����� ���� Ȯ��
        boolean isValidUser = boardDao.isValidUser(id, password);

        // 3. ����� ���� ������ �̵�
        if (isValidUser) {
            // ����ڰ� ��ȿ�ϸ� ���ǿ� ����� ID ����
            HttpSession session = request.getSession();
            session.setAttribute("Id", id);

            // ModelAndView�� ����Ͽ� �� �̸��� ���� ����
            ModelAndView mav = new ModelAndView("mainBoardView");
            mav.addObject("Id", id); // �𵨿� ����� ID �߰�

            return mav;
        } else {
            // ����ڰ� ��ȿ���� ������
            ModelAndView mav = new ModelAndView("insertBoardView");
            return mav;
        }
    }
}
