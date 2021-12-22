package com.app.webmongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.webmongo.model.User;
import com.app.webmongo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User registrateUser(User user) {
		return userService.registrateUser(user);
	}
	
	@GetMapping("/emailexist/{email}")
	public boolean emailExist(@PathVariable("email") String email) {
		return userService.emailExist(email);
	}
	
	@GetMapping("/emailexist/{email}/{password}")
	public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.authenticateUser(email, password);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Integer deleteUser(@PathVariable("id") Integer id) {
		return userService.deleteUser(id);
	}
}
