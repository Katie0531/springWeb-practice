package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class GetDiaryBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GetDiaryBoardController ���� !!");


		//1.seq ���� �̸��� ���޵Ǵ� �����͸� �ޱ�
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. ���κ��� ������ �������� (BoardDo, BoardDao)
		BoardDo ddo = new BoardDo();
		ddo.setSeq(seq);
		
		BoardDao ddao = new BoardDao();
		BoardDo board = ddao.getOneDiary(ddo);
		
		
		//3. ��� ȣ���ϸ鼭, board ������ ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("diaryBoardView");
		
		
		
		
		return mav;
	}

}
