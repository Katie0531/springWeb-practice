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
        // 정렬 방식 파라미터를 받아오기
        String orderByDescParam = request.getParameter("orderByDesc");
        boolean orderByDesc = (orderByDescParam != null && orderByDescParam.equals("true"));

        // 정렬 방식에 따라 데이터 가져오기
        ArrayList<BoardDo> dList;

        if (keyword != null && !keyword.isEmpty()) {
            dList = bService.searchDiaryBoard(keyword);
        } else {
            // 정렬 방식에 따라 메서드 호출
            dList = orderByDesc ? bService.diaryBoard(true) : bService.diaryBoard(false);
        }

        for (BoardDo board : dList) {
            System.out.println("-->" + board.toString());
        }

        // 뷰어를 호출하면서 데이터 넘기기
        ModelAndView mav = new ModelAndView();
        mav.addObject("dList", dList);
        mav.addObject("keyword", keyword); // 검색어를 뷰에 전달
        mav.setViewName("diaryBoardView");

        return mav;
	}
	
	

}
