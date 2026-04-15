package com.api.dataprovider;

public class pojouser {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	
	
	public pojouser(){
	
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
	@Override
	public String toString() {
		return "pojouser [username=" + username + ", password=" + password + "]";
	}
	public pojouser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	
	
}
