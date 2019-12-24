package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.User;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@PreAuthorize("permitAll()")
	@PostMapping
	public Response addUser(@RequestBody User user) {
		System.out.println("Try to add a user: " + user);
		return userService.register(user);
	}
	
	@PutMapping
	public Response changeUser(@RequestBody User user, Authentication authentication) {
		return userService.changePassword(user, authentication);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
