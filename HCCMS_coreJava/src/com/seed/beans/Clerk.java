package com.seed.beans;

/*This Is Pojo*/

public class Clerk {
	private String username;
	private String password;
	private String email;
	
	
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
	
	public String getemail() {
		return email;
	}
	public void setemail(String username) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Clerk [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
