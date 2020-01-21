package com.mercury.SpringBootRestDemo.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.beans.User;
import com.mercury.SpringBootRestDemo.http.AuthenticationSuccessResponse;
import com.mercury.SpringBootRestDemo.http.Response;


public class SecurityUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message)));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
    public static void sendAuthenticationSuccessResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception, MyUser user)
			throws IOException {
		Response response = new AuthenticationSuccessResponse(exception == null ? true : false, status, message, user);
		flushResponse(httpServletResponse, response);
	}

    public static void flushResponse(HttpServletResponse httpServletResponse, Response response) throws IOException {
		httpServletResponse.setContentType("application/json;charset=UTF-8");
		httpServletResponse.setStatus(response.getCode());
		PrintWriter writer = httpServletResponse.getWriter();
		writer.write(mapper.writeValueAsString(response));
		writer.flush();
		writer.close();
	}
	
	public static boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		boolean isAdmin = false;
		System.out.println("Check if is admin in Security Utils");
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}

	
}
