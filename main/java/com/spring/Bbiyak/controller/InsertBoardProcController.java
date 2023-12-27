package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class InsertBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardProcController --> ");
		
		
		//1. 추가될 데이터 가져오기 (request)
		String password = request.getParameter("password");
		String id = request.getParameter("id");

		
		//2. 디비에 저장
		BoardDo bdo = new BoardDo();
		bdo.setId(id);
		bdo.setPassword(password);

		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		
		//3. 뷰어 이용하여 추가된 데이터 확인 !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}














