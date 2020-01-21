package com.mercury.SpringBootRestDemo.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.mercury.SpringBootRestDemo.security.SecurityUtils;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		System.out.println("Throw out authentication failed");
		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, "Authentication failed", exception);
	}

}
