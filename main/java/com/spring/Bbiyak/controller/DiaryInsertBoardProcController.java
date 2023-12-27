package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class DiaryInsertBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("DiaryInsertBoardProcController --> ");
			
			
			//1. 추가될 데이터 가져오기 (request)
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
	
			
			//2. 디비에 저장
			BoardDo ddo = new BoardDo();
			ddo.setTitle(title);
			ddo.setWriter(writer);
			ddo.setContent(content);
	
			
			BoardDao ddao = new BoardDao();
			ddao.diaryInsertBoard(ddo);
			
			
			//3. 뷰어 이용하여 추가된 데이터 확인 !!
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:diaryBoard.do");
			
			return mav;
	}

}
