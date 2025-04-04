package com.spring.boardex.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.boardex.common.JdbcUtil;
import com.spring.boardex.impl.BoardDo;

public class BoardClient {


	public static void main(String[] args) {
		JdbcUtil jUtil = new JdbcUtil();
		jUtil.getConnection();
		
		ApplicationContext context =
				new GenericXmlApplicationContext("boardSetting.xml");
		
		BoardService bService = (BoardService) context.getBean("boardService");
		BoardService dService = (BoardService) context.getBean("boardService");
		
//		//1. 데이터 저장
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle("title2");
//		bdo.setWriter("writer2");
//		bdo.setContent("content2");
//		
//		bService.insertBoard(bdo);
		
		//2. 전체 데이터 가져오기
		ArrayList<BoardDo> bList = bService.getBoardList();
		for(BoardDo bdo: bList) {
			System.out.println("-->" + bdo.toString());
		}
		
		//3. 하나의 데이터 가져오기
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(2);
//		BoardDo board = bService.getOneBoard(bdo);
//		System.out.println("[one board] -->" + board.toString());
		
//		//4. 하나의 데이터 수정하기
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(2);
//		bdo.setTitle("title 수정");
//		bdo.setContent("content 수정");
//		
//		bService.updateBoard(bdo);
//		
//		//2. 전체 데이터 가져오기
//		bList = bService.getBoardList();
//		for(BoardDo board: bList) {
//			System.out.println("-->" + bdo.toString());
//		}
		
		//5. 하나의 데이터 삭제하기
		BoardDo bdo = new BoardDo();
		bdo.setSeq(1);
		bService.deleteBoard(bdo);
		
		//2. 전체 데이터 가져오기
		bList = bService.getBoardList();
		for(BoardDo login: bList) {
			System.out.println("-->" + bdo.toString());
		}
		
		
		

		
		//1. 전체 게시판 가져오기
		ArrayList<BoardDo> dList = dService.diaryBoard();
		for(BoardDo ddo: dList) {
			System.out.println("-->" + ddo.toString());
		}
		
		//2. 전체 게시판 가져오기
		dList = dService.diaryBoard();
		for(BoardDo ddo: dList) {
			System.out.println("-->" + ddo.toString());
		}
		
		
		// 검색어 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색어를 입력하세요: ");
        String keyword = scanner.nextLine();

     // 검색어를 이용한 전체 게시글 가져오기
        ArrayList<BoardDo> searchedList = dService.searchDiaryBoard(keyword);

	}

}
