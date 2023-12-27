package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class DiaryModifyBoardProcController  implements Controller{


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DiaryModifyProcController --> ");
		
		//1. 수정된 데이터를 가져와 보기
		String seqParam = request.getParameter("seq");
		int seq = (seqParam != null && !seqParam.isEmpty()) ? Integer.parseInt(seqParam) : 0;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("seq " + seq +
							"title" + title +
							"content" + content );
		
		
		//2. 수정된 데이터 디비에 저장
		BoardDo ddo = new BoardDo();
		ddo.setSeq(seq);
		ddo.setTitle(title);
		ddo.setContent(content);
		
		BoardDao ddao = new BoardDao();
		ddao.updateDiary(ddo);
		
		//3. 뷰어 호출
		ModelAndView mav = new ModelAndView();
		mav.setViewName("diaryBoardView");
		
		

		
		return mav;
	}

}
