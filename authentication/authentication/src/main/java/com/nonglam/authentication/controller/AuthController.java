package com.nonglam.authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello world!";
	}
}
