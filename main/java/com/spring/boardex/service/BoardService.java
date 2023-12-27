package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	//�Խ��� ������ ����
	void insertBoard(BoardDo bdo);
	
	//��ü �α��� ������ ��������
	ArrayList<BoardDo> getBoardList();
	
	//�ϳ��� �Խ��� ������ ��������
	BoardDo getOneBoard(BoardDo bdo);
	
	//4. �ϳ��� �Խ��� ������ �����ϱ�
	void updateBoard(BoardDo bdo);
	
	//5. �ϳ��� �Խ��� �����ϱ�
	void deleteBoard(BoardDo bdo);
	
	//��ü �Խ��� ����
	void diaryBoard(BoardDo ddo);


	//�Խ��� �����ϱ�
	void updateDiary(BoardDo ddo);

	//�ϳ��� �Խ��� ��������
	void getOneDiary(BoardDo ddo);


	// �˻�� �̿��� ��ü �Խñ� ��������
    ArrayList<BoardDo> searchDiaryBoard(String keyword);

	void searchDiaryBoard(BoardDo ddo);
	
	// ������ �ڵ�
    ArrayList<BoardDo> diaryBoard();

    // �߰� �ڵ�
    ArrayList<BoardDo> diaryBoard(boolean orderByDesc);

	void diaryInsertBoard(BoardDo ddo);
}
