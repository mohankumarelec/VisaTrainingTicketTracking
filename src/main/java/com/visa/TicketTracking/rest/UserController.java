package com.visa.TicketTracking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.TicketTracking.entity.User;
import com.visa.TicketTracking.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public @ResponseBody List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User u) {
		userService.addUser(u);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

}
