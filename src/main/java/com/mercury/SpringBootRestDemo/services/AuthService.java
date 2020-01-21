package com.mercury.SpringBootRestDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.daos.MyUserDao;
import com.mercury.SpringBootRestDemo.daos.UserDao;
import com.mercury.SpringBootRestDemo.http.AuthenticationSuccessResponse;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class AuthService {
	
	@Autowired
	private MyUserDao myUserDao;

	public Response checklogin(Authentication authentication) {
		System.out.println("In Authen Service");
		if (authentication != null) {
			Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", myUserDao.findByEmail(authentication.getName()));
			System.out.println("Login Success");
			return response;
		} else {
			System.out.println("Login Failed");
			return new Response(false);
		}
	}

}
