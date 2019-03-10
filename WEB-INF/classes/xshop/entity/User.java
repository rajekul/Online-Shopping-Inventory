package xshop.entity;

import java.util.List;
import java.util.ArrayList;

public  class User{
    String username;
    String password;
    String type;
    String status;
	
	public User(String username,String password,String type,String status) {
		this.username = username;
		this.password = password;
		this.type = type;
		this.status = status;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public String getType() {
		return type;
	}
	
	public String getStatus() {
		return status;
	}

}