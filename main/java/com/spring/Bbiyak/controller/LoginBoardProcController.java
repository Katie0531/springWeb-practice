package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;

public class LoginBoardProcController implements Controller {

    private BoardDao boardDao;

    // BoardDao를 생성자나 세터 메서드를 통해 주입
    public LoginBoardProcController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LoginBoardProcController --> ");

        // 1. 데이터 가져오기 (request)
        String password = request.getParameter("password");
        String id = request.getParameter("id");

        // 2. 데이터베이스에서 사용자 정보 확인
        boolean isValidUser = boardDao.isValidUser(id, password);

        // 3. 결과에 따라 페이지 이동
        if (isValidUser) {
            // 사용자가 유효하면 세션에 사용자 ID 저장
            HttpSession session = request.getSession();
            session.setAttribute("Id", id);

            // ModelAndView를 사용하여 뷰 이름과 모델을 설정
            ModelAndView mav = new ModelAndView("mainBoardView");
            mav.addObject("Id", id); // 모델에 사용자 ID 추가

            return mav;
        } else {
            // 사용자가 유효하지 않으면
            ModelAndView mav = new ModelAndView("insertBoardView");
            return mav;
        }
    }
}
