package com.mercury.SpringBootRestDemo.http;

import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.beans.User;

public class AuthenticationSuccessResponse extends Response {

	private MyUser user;

	public AuthenticationSuccessResponse(boolean success, int code, String message, MyUser myUser) {
		super(success, code, message);
		this.user = myUser;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

}
