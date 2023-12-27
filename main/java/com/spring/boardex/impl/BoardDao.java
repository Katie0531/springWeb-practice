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
   
   //1. ������ ����   
   public void insertBoard(BoardDo bdo) {
      System.out.println("insertBoard() -->");
      
      //1. ��� ����
      conn = JdbcUtil.getConnection();
      String sql = "insert into bbiyak values (null,?,?)";
      try {
         //2. sql�� �ϼ�
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,  bdo.getId());
         pstmt.setString(2,  bdo.getPassword());

         
         //3. sql�� ó��
         pstmt.executeUpdate();
         
         //4. ���� ����
         JdbcUtil.close(rs,  pstmt, conn);
         System.out.println("insertBoard() ó�� �Ϸ�");
         
         } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }
   
   //2. ��ü ������ ��������
   public ArrayList<BoardDo> getBoardList() {
      System.out.println("getBoardList)_ ==>");
      ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
      try {
         //�����ͺ��̽� ����
         conn = JdbcUtil.getConnection();
         
         //sql�� �ϼ�
         String sql = "select * from bbiyak";
         pstmt = conn.prepareStatement(sql);
         //sql�� ����
         rs = pstmt.executeQuery();
         while(rs.next()) {
            BoardDo bdo = new BoardDo();
            bdo.setSeq(rs.getInt(1)); //seq
            bdo.setId(rs.getString(2));
            bdo.setPassword(rs.getString(3));
            
            bList.add(bdo);
         }
         JdbcUtil.close(rs, pstmt, conn);
         System.out.println("-- �����ͺ��̽� ó�� �Ϸ�(getBoardList()) --");
   
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bList;
      
      
            
      }

   //3. seq=? �� �ϳ��� ������ ��������
   public BoardDo getOneBoard(BoardDo bdo) {
	   System.out.println("getOneBoard() --> ");
	   //����Ÿ��
	   BoardDo bbiyak = new BoardDo();
	   
	   //1. ��� ����
	   conn = JdbcUtil.getConnection();
	   
	   //2. sql�� �ϼ�(?? ó�� �ֵ� ����)
	   String sql = "select * from bbiyak where seq=?";
	   
	   try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bdo.getSeq());
		
		//3. sql�� ����
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bbiyak.setSeq(rs.getInt(1));
			bbiyak.setId(rs.getString(2));
			bbiyak.setPassword(rs.getString(3));
		}
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("getOneBoard ó�� �Ϸ�!!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   
			   
			   
	   return bbiyak;
   }

   //4. seq=?�� �����͸� �����ϱ�
   public void updateBoard(BoardDo bdo) {
	   System.out.println("updateBoard() --> ");
	   
	   //1. ��� ���� 
	   conn = JdbcUtil.getConnection();
	   String sql = "update bbiyak set title=?, content=? where seq=?";
	   
	   //2. sql�� �ϼ�
	   try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bdo.getId());
		pstmt.setString(2, bdo.getPassword());
		pstmt.setInt(3, bdo.getSeq());
		   
		//3. sql�� ����
		pstmt.executeUpdate();
		
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("updateBoard ó�� �Ϸ� !! ");
		   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
   }

   //5. seq=?�� ������ �����ϱ�
   public void deleteBoard(BoardDo bdo) {
	   System.out.println("deleteBoard() ==>");
	   
	   //1. ��� ����
	   conn = JdbcUtil.getConnection();
	   
	   //2. sql�� �ϼ�
	   String sql = "delete from bbiyak where seq=?";
	   try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bdo.getSeq());
		
		//3. sql�� ����
		pstmt.executeUpdate();
		JdbcUtil.close(rs, pstmt, conn);
		System.out.println("deleteBoard ó�� �Ϸ�");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	   }
// 6. �־��� ID�� ��й�ȣ�� ����ڰ� �����ϴ��� Ȯ��
   public boolean isValidUser(String id, String password) {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           // �����ͺ��̽� ������ �����ؾ� �մϴ�.
           conn = JdbcUtil.getConnection();

           String sql = "SELECT * FROM bbiyak WHERE id = ? AND password = ?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, id);
           pstmt.setString(2, password);

           rs = pstmt.executeQuery();

           return rs.next(); // ����� ������ true, ������ false ��ȯ

       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       } finally {
           // ���ҽ��� �ݾƾ� �մϴ�.
           JdbcUtil.close(rs, pstmt, conn);
       }
   }
       
       
       
     //�Խñ� ���
       public void diaryInsertBoard(BoardDo ddo) {
          System.out.println("diaryBoard() -->");
          
          //1. ��� ����
          conn = JdbcUtil.getConnection();
          String sql = "insert into bbiyakdiary values (null,?,?,?)";
          try {
             //2. sql�� �ϼ�
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1,  ddo.getTitle());
             pstmt.setString(2,  ddo.getWriter());
             pstmt.setString(3,  ddo.getContent());

             
             //3. sql�� ó��
             pstmt.executeUpdate();
             
             //4. ���� ����
             JdbcUtil.close(rs,  pstmt, conn);
             System.out.println("diaryBoard() ó�� �Ϸ�");
             
             } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
       
       }
       
    // ��ü �Խñ�
       public ArrayList<BoardDo> diaryBoard() {
           return diaryBoard(false);
       }

       // �߰� �ڵ�
       // ��ü �Խñ� �������� (�������� �Ǵ� ��������)
       public ArrayList<BoardDo> diaryBoard(boolean orderByDesc) {
           System.out.println("diaryBoard ==>");
           ArrayList<BoardDo> dList = new ArrayList<BoardDo>();
           try {
               // �����ͺ��̽� ����
               conn = JdbcUtil.getConnection();

               // ���� ��Ŀ� ���� sql�� �ϼ�
               String sql = orderByDesc ? "SELECT * FROM bbiyakdiary ORDER BY seq DESC" : "SELECT * FROM bbiyakdiary ORDER BY seq ASC";
               pstmt = conn.prepareStatement(sql);

               // sql�� ����
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
               System.out.println("-- �����ͺ��̽� ó�� �Ϸ�(diaryBoard()) --");

           } catch (SQLException e) {
               e.printStackTrace();
           }
           return dList;
       }
	
	
	
	   //3. seq=? �� �ϳ��� �Խñ� ��������
	   public BoardDo getOneDiary(BoardDo ddo) {
		   System.out.println("getOneBoard() --> ");
		   //����Ÿ��
		   BoardDo bbiyakdiary = new BoardDo();
		   
		   //1. ��� ����
		   conn = JdbcUtil.getConnection();
		   
		   //2. sql�� �ϼ�(?? ó�� �ֵ� ����)
		   String sql = "select * from bbiyakdiary where seq=?";
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ddo.getSeq());
			
			//3. sql�� ����
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbiyakdiary.setSeq(rs.getInt(1));
				bbiyakdiary.setTitle(rs.getString(2));
				bbiyakdiary.setWriter(rs.getString(3));
				bbiyakdiary.setContent(rs.getString(4));
				
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneDiary ó�� �Ϸ�!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
				   
				   
		   return bbiyakdiary;
	   }
	   
	   
	   
	 //4. seq=?�� �Խñ��� �����ϱ�
	   public void updateDiary(BoardDo ddo) {
		   System.out.println("updateDiary() --> ");
		   
		   //1. ��� ���� 
		   conn = JdbcUtil.getConnection();
		   String sql = "update bbiyakdiary set title=?, content=? where seq=?";
		   
		   //2. sql�� �ϼ�
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ddo.getSeq());
			pstmt.setString(2, ddo.getTitle());
			pstmt.setString(3, ddo.getContent());
			
			   
			//3. sql�� ����
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateDiary ó�� �Ϸ� !! ");
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
	   
	   
	// �Խñ� �˻� ��� �߰�
	   public ArrayList<BoardDo> searchDiaryBoard(String keyword) {
	       System.out.println("searchDiaryBoard() ==>");
	       ArrayList<BoardDo> dList = new ArrayList<BoardDo>();
	       try {
	           // �����ͺ��̽� ����
	           conn = JdbcUtil.getConnection();

	           // sql�� �ϼ� (���� �Ǵ� ���뿡 Ű���尡 ���Ե� �Խñ� �˻�)
	           String sql = "SELECT * FROM bbiyakdiary WHERE title LIKE ? OR content LIKE ?";
	           pstmt = conn.prepareStatement(sql);
	           pstmt.setString(1, "%" + keyword + "%");
	           pstmt.setString(2, "%" + keyword + "%");

	           // sql�� ����
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
	           System.out.println("-- �����ͺ��̽� ó�� �Ϸ�(searchDiaryBoard()) --");

	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return dList;
	   }
}
   






