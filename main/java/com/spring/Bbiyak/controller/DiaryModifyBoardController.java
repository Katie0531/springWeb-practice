package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class DiaryModifyBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DiaryModifyController --> ");
				
			//1. seq 값 가져오기
			int seq = Integer.parseInt(request.getParameter("seq"));
					
			//2. 디비로부터 seq에 해당되는 데이터 가져오기
			BoardDo ddo = new BoardDo();
			ddo.setSeq(seq);
			BoardDao ddao = new BoardDao();
			BoardDo board = ddao.getOneDiary(ddo);
			
			//3. mav를 이용하여 뷰어에 데이터 전달
			ModelAndView mav = new ModelAndView();
			mav.addObject("board", board);
			mav.setViewName("diaryModifyBoardView");
			
			
			return mav;
			}

}
