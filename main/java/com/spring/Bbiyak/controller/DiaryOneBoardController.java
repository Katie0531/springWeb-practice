package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class DiaryOneBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("DiaryOneBoardController -->");
			
			//1.seq 변수 이름을 전달되는 데이터를 받기
			String seqParam = request.getParameter("seq");
			
			int seq = (seqParam != null && !seqParam.isEmpty()) ? Integer.parseInt(seqParam) : 0;
			
			//2. 디비로부터 데이터 가져오기 (BoardDo, BoardDao)
			BoardDo ddo = new BoardDo();
			ddo.setSeq(seq);
			
			BoardDao ddao = new BoardDao();
			BoardDo bbiyakdiary = ddao.getOneDiary(ddo);
			
			
			//3. 뷰어 호출하면서, board 데이터 전달
			ModelAndView mav = new ModelAndView();
			mav.addObject("bbiyakdiary", bbiyakdiary);
			mav.setViewName("diaryOneBoardView");
			
			
			
			
			return mav;
	}

}
