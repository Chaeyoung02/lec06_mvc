package com.gn.user.vo;

public class User {
	private int user_no;
	private String user_name;
	private String user_pw;
	private String user_id;
	
	
	public User() {
		super();
		
	}
	public User(int user_no, String user_id, String user_pw, String user_name) {
		super();
		this.user_no = user_no;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_id = user_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_name=" + user_name + ", user_pw=" + user_pw + ", user_id=" + user_id
				+ "]";
	}
	
	
}
