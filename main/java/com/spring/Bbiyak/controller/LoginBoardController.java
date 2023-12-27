package com.spring.Bbiyak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginController() --> ");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginBoardView");
		
		
		return mav;
	}

}
