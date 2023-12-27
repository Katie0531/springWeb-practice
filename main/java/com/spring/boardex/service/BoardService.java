package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	//게시판 데이터 저장
	void insertBoard(BoardDo bdo);
	
	//전체 로그인 데이터 가져오기
	ArrayList<BoardDo> getBoardList();
	
	//하나의 게시판 데이터 가져오기
	BoardDo getOneBoard(BoardDo bdo);
	
	//4. 하나의 게시판 데이터 수정하기
	void updateBoard(BoardDo bdo);
	
	//5. 하나의 게시판 삭제하기
	void deleteBoard(BoardDo bdo);
	
	//전체 게시판 저장
	void diaryBoard(BoardDo ddo);


	//게시판 수정하기
	void updateDiary(BoardDo ddo);

	//하나의 게시판 가져오기
	void getOneDiary(BoardDo ddo);


	// 검색어를 이용한 전체 게시글 가져오기
    ArrayList<BoardDo> searchDiaryBoard(String keyword);

	void searchDiaryBoard(BoardDo ddo);
	
	// 수정된 코드
    ArrayList<BoardDo> diaryBoard();

    // 추가 코드
    ArrayList<BoardDo> diaryBoard(boolean orderByDesc);

	void diaryInsertBoard(BoardDo ddo);
}
