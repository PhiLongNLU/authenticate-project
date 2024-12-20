package com.nonglam.authentication.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.nonglam.authentication.exception.UserNotFoundException;
import com.nonglam.authentication.model.User;
import com.nonglam.authentication.service.UserDaoService;

@RestController
@RequestMapping("/users")
public class AuthController {
	
	@Autowired
	private UserDaoService service;
	
	
	@GetMapping
	public List<User> getAllUser(){
		return service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public User getUser(@PathVariable int id) throws Exception {
		User user = service.findOne(id);
		if(user == null) {
			throw new Exception("user not found!");
		}
		return user;
	}
	
	@PutMapping(path = "/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		return service.update(id, user);
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}