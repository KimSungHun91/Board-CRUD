package org.green.board.dto;

public class User {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone1;
	private String user_phone2;
	private String user_phone3;
	
	public User() {}
	
	public User(String user_id) {
		super();
		this.user_id = user_id;
	}

	public User(String user_id, String user_pw, String user_name, String user_phone1) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_phone1 = user_phone1;
	}

	public User(String user_id, String user_pw, String user_name, String user_phone1, String user_phone2,
			String user_phone3) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_phone1 = user_phone1;
		this.user_phone2 = user_phone2;
		this.user_phone3 = user_phone3;
	}

	public String getUser_phone2() {
		return user_phone2;
	}

	public void setUser_phone2(String user_phone2) {
		this.user_phone2 = user_phone2;
	}

	public String getUser_phone3() {
		return user_phone3;
	}

	public void setUser_phone3(String user_phone3) {
		this.user_phone3 = user_phone3;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone1() {
		return user_phone1;
	}

	public void setUser_phone1(String user_phone1) {
		this.user_phone1 = user_phone1;
	}
}
