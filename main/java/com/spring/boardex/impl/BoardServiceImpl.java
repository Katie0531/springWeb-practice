package com.spring.boardex.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardex.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//boardDao 객체 이용 (중요)
	@Autowired
	private BoardDao bdao;

	@Autowired
	private BoardDao ddao;
	
	
	@Override
	public void insertBoard(BoardDo bdo) {
		bdao.insertBoard(bdo);
	}
	@Override
	public ArrayList<BoardDo> getBoardList() {
		return bdao.getBoardList();
	}


	@Override
	public BoardDo getOneBoard(BoardDo bdo) {
		return bdao.getOneBoard(bdo);
	}
	
	@Override
	public void updateBoard(BoardDo bdo) {
		bdao.updateBoard(bdo);
		
	}
	@Override
	public void deleteBoard(BoardDo bdo) {
		bdao.deleteBoard(bdo);
	}
	
	@Override
    public ArrayList<BoardDo> diaryBoard() {
        return ddao.diaryBoard(false);
    }

    @Override
    public ArrayList<BoardDo> diaryBoard(boolean orderByDesc) {
        return ddao.diaryBoard(orderByDesc);
    }

	@Override
	public void updateDiary(BoardDo ddo) {
		ddao.updateDiary(ddo);
	}
	@Override
	public void getOneDiary(BoardDo ddo) {
		ddao.getOneDiary(ddo);
	}
	@Override
	public void searchDiaryBoard(BoardDo ddo) {
		ddao.getOneDiary(ddo);
	}
	@Override
    public ArrayList<BoardDo> searchDiaryBoard(String keyword) {
        return ddao.searchDiaryBoard(keyword);
    }
	@Override
	public void diaryInsertBoard(BoardDo ddo) {
		
		
	}
	@Override
	public void diaryBoard(BoardDo ddo) {
		// TODO Auto-generated method stub
		
	}

	
}
