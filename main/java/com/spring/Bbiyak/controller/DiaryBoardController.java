package com.spring.Bbiyak.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;
import com.spring.boardex.service.BoardService;

public class DiaryBoardController implements Controller{

	
	 @Autowired
	 private BoardService bService;
	 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("keyword");
        // ���� ��� �Ķ���͸� �޾ƿ���
        String orderByDescParam = request.getParameter("orderByDesc");
        boolean orderByDesc = (orderByDescParam != null && orderByDescParam.equals("true"));

        // ���� ��Ŀ� ���� ������ ��������
        ArrayList<BoardDo> dList;

        if (keyword != null && !keyword.isEmpty()) {
            dList = bService.searchDiaryBoard(keyword);
        } else {
            // ���� ��Ŀ� ���� �޼��� ȣ��
            dList = orderByDesc ? bService.diaryBoard(true) : bService.diaryBoard(false);
        }

        for (BoardDo board : dList) {
            System.out.println("-->" + board.toString());
        }

        // �� ȣ���ϸ鼭 ������ �ѱ��
        ModelAndView mav = new ModelAndView();
        mav.addObject("dList", dList);
        mav.addObject("keyword", keyword); // �˻�� �信 ����
        mav.setViewName("diaryBoardView");

        return mav;
	}
	
	

}
