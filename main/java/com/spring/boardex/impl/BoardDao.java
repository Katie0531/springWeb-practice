package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDao")
public class BoardDao {
   
   private Connection conn = null;
   private PreparedStatement pstmt = null;
   private ResultSet rs = null;
   
   //1. 데이터 저장   
   public void insertBoard(BoardDo bdo) {
      System.out.println("insertBoard() -->");
      
      //1. 디비에 연결
      conn = JdbcUtil.getConnection();
      String sql = "insert into bbiyak values (null,?,?)";
      try {
         //2. sql문 완성
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,  bdo.getId());
         pstmt.setString(2,  bdo.getPassword());

         
         //3. sql문 처리
         pstmt.executeUpdate();
         
         //4. 연결 해제
         JdbcUtil.close(rs,  pstmt, conn);
         System.out.println("insertBoard() 처리 완료");
         
         } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }
   
   //2. 전체 데이터 가져오기
   public ArrayList<BoardDo> getBoardList() {
      System.out.println("getBoardList)_ ==>");
      ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
      try {
         //데이터베이스 연결
         conn = JdbcUtil.getConnection();
         
         //sql문 완성
         String sql = "select * from bbiyak";
         pstmt = conn.prepareStatement(sql);
         //sql문 실행
         rs = pstmt.executeQuery();
         while(rs.next()) {
            BoardDo bdo = new BoardDo();
            bdo.setSeq(rs.getInt(1)); //seq
            bdo.setId(rs.getString(2));
            bdo.setPassword(rs.getString(3));
            
            bList.add(bdo);
         }
         JdbcUtil.close(rs, pstmt, conn);
         System.out.println("-- 데이터베이스 처리 완료(getBoardList()) --");
   
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bList;
      
      
            
      }

   //3. seq=? 인 하나의 데이터 가져오기
   public BoardDo getOneBoard(BoardDo bdo) {
	   System.out.println("getOneBoard() --> ");
	   //리턴타입
	   BoardDo bbiyak = new BoardDo();
	   
	   //1. 디비 연결
	   conn = JdbcUtil.getConnection();
	   
	   //2. sql문 완성(?? 처리 주된 내용)
	   String sql = "select * from bbiyak where seq=?";
	   
	   try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bdo.getSeq());
		
		//3. sql문 실행
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bbiyak.setSeq(rs.getInt(1));
			bbiyak.setId(rs.getString(2));
			bbiyak.setPassword(rs.getString(3));
		}
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("getOneBoard 처리 완료!!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   
			   
			   
	   return bbiyak;
   }

   //4. seq=?인 데이터를 수정하기
   public void updateBoard(BoardDo bdo) {
	   System.out.println("updateBoard() --> ");
	   
	   //1. 디비 연결 
	   conn = JdbcUtil.getConnection();
	   String sql = "update bbiyak set title=?, content=? where seq=?";
	   
	   //2. sql문 완성
	   try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bdo.getId());
		pstmt.setString(2, bdo.getPassword());
		pstmt.setInt(3, bdo.getSeq());
		   
		//3. sql문 실행
		pstmt.executeUpdate();
		
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("updateBoard 처리 완료 !! ");
		   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
   }

   //5. seq=?인 데이터 삭제하기
   public void deleteBoard(BoardDo bdo) {
	   System.out.println("deleteBoard() ==>");
	   
	   //1. 디비 연결
	   conn = JdbcUtil.getConnection();
	   
	   //2. sql문 완성
	   String sql = "delete from bbiyak where seq=?";
	   try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bdo.getSeq());
		
		//3. sql문 실행
		pstmt.executeUpdate();
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("deleteBoard 처리 완료");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	   }
// 6. 주어진 ID와 비밀번호로 사용자가 존재하는지 확인
   public boolean isValidUser(String id, String password) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           // 데이터베이스 연결을 설정해야 합니다.
           conn = JdbcUtil.getConnection();

           String sql = "SELECT * FROM bbiyak WHERE id = ? AND password = ?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, id);
           pstmt.setString(2, password);

           rs = pstmt.executeQuery();

           return rs.next(); // 결과가 있으면 true, 없으면 false 반환

       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       } finally {
           // 리소스를 닫아야 합니다.
           JdbcUtil.close(rs, pstmt, conn);
       }
   }
       
       
       
     //게시글 등록
       public void diaryInsertBoard(BoardDo ddo) {
          System.out.println("diaryBoard() -->");
          
          //1. 디비에 연결
          conn = JdbcUtil.getConnection();
          String sql = "insert into bbiyakdiary values (null,?,?,?)";
          try {
             //2. sql문 완성
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1,  ddo.getTitle());
             pstmt.setString(2,  ddo.getWriter());
             pstmt.setString(3,  ddo.getContent());

             
             //3. sql문 처리
             pstmt.executeUpdate();
             
             //4. 연결 해제
             JdbcUtil.close(rs,  pstmt, conn);
             System.out.println("diaryBoard() 처리 완료");
             
             } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
       
       }
       
    // 전체 게시글
       public ArrayList<BoardDo> diaryBoard() {
           return diaryBoard(false);
       }

       // 추가 코드
       // 전체 게시글 가져오기 (오름차순 또는 내림차순)
       public ArrayList<BoardDo> diaryBoard(boolean orderByDesc) {
           System.out.println("diaryBoard ==>");
           ArrayList<BoardDo> dList = new ArrayList<BoardDo>();
           try {
               // 데이터베이스 연결
               conn = JdbcUtil.getConnection();

               // 정렬 방식에 따라 sql문 완성
               String sql = orderByDesc ? "SELECT * FROM bbiyakdiary ORDER BY seq DESC" : "SELECT * FROM bbiyakdiary ORDER BY seq ASC";
               pstmt = conn.prepareStatement(sql);

               // sql문 실행
               rs = pstmt.executeQuery();

               while (rs.next()) {
                   BoardDo ddo = new BoardDo();
                   ddo.setSeq(rs.getInt(1)); // seq
                   ddo.setTitle(rs.getString(2));
                   ddo.setWriter(rs.getString(3));
                   ddo.setContent(rs.getString(4));

                   dList.add(ddo);
               }
               JdbcUtil.close(rs, pstmt, conn);
               System.out.println("-- 데이터베이스 처리 완료(diaryBoard()) --");

           } catch (SQLException e) {
               e.printStackTrace();
           }
           return dList;
       }
	
	
	
	   //3. seq=? 인 하나의 게시글 가져오기
	   public BoardDo getOneDiary(BoardDo ddo) {
		   System.out.println("getOneBoard() --> ");
		   //리턴타입
		   BoardDo bbiyakdiary = new BoardDo();
		   
		   //1. 디비 연결
		   conn = JdbcUtil.getConnection();
		   
		   //2. sql문 완성(?? 처리 주된 내용)
		   String sql = "select * from bbiyakdiary where seq=?";
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ddo.getSeq());
			
			//3. sql문 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbiyakdiary.setSeq(rs.getInt(1));
				bbiyakdiary.setTitle(rs.getString(2));
				bbiyakdiary.setWriter(rs.getString(3));
				bbiyakdiary.setContent(rs.getString(4));
				
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneDiary 처리 완료!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
				   
				   
		   return bbiyakdiary;
	   }
	   
	   
	   
	 //4. seq=?인 게시글을 수정하기
	   public void updateDiary(BoardDo ddo) {
		   System.out.println("updateDiary() --> ");
		   
		   //1. 디비 연결 
		   conn = JdbcUtil.getConnection();
		   String sql = "update bbiyakdiary set title=?, content=? where seq=?";
		   
		   //2. sql문 완성
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ddo.getSeq());
			pstmt.setString(2, ddo.getTitle());
			pstmt.setString(3, ddo.getContent());
			
			   
			//3. sql문 실행
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateDiary 처리 완료 !! ");
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
	   
	   
	// 게시글 검색 기능 추가
	   public ArrayList<BoardDo> searchDiaryBoard(String keyword) {
	       System.out.println("searchDiaryBoard() ==>");
	       ArrayList<BoardDo> dList = new ArrayList<BoardDo>();
	       try {
	           // 데이터베이스 연결
	           conn = JdbcUtil.getConnection();

	           // sql문 완성 (제목 또는 내용에 키워드가 포함된 게시글 검색)
	           String sql = "SELECT * FROM bbiyakdiary WHERE title LIKE ? OR content LIKE ?";
	           pstmt = conn.prepareStatement(sql);
	           pstmt.setString(1, "%" + keyword + "%");
	           pstmt.setString(2, "%" + keyword + "%");

	           // sql문 실행
	           rs = pstmt.executeQuery();

	           while (rs.next()) {
	               BoardDo ddo = new BoardDo();
	               ddo.setSeq(rs.getInt(1)); // seq
	               ddo.setTitle(rs.getString(2));
	               ddo.setWriter(rs.getString(3));
	               ddo.setContent(rs.getString(4));

	               dList.add(ddo);
	           }
	           JdbcUtil.close(rs, pstmt, conn);
	           System.out.println("-- 데이터베이스 처리 완료(searchDiaryBoard()) --");

	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return dList;
	   }
}
   






