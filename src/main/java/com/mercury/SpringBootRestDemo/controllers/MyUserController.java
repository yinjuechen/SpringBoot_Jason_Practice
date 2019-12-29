package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.MyUserService;

@RestController
@RequestMapping("/myusers")
public class MyUserController {
	@Autowired
	private MyUserService myUserService;

	@GetMapping
	public List<MyUser> getAll() {
		return myUserService.getAll();
	}
	
	@PostMapping
	public Response register(@RequestBody MyUser user){
		return myUserService.register(user);
	}
}
