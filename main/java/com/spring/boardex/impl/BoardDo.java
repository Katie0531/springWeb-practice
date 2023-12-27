package com.spring.boardex.impl;

public class BoardDo {
	private int seq;
	private String id;
	private String password;
	private String title;
	private String writer;
	private String content;

	

	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + 
				", id=" + id + 
				", password=" + password + 
				 "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}


