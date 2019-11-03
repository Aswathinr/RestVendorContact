package com.faith.model;

public class LoginUser {
	private Integer id;
	private String username;
	private String password;
	private Integer rollId;
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUser(Integer id, String username, String password, Integer rollId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rollId = rollId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRollId() {
		return rollId;
	}

	public void setRollId(Integer rollId) {
		this.rollId = rollId;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", rollId=" + rollId + "]";
	}

	

}
