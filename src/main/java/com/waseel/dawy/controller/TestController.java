package com.waseel.dawy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController{

	@GetMapping("admin-role")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String test() {
		return "Hello ADMIN";
	}
	
	@GetMapping("user-role")
	@PreAuthorize("hasAuthority('USER')")
	public String test1() {
		return "Hello USER";
	}
	
	
	@GetMapping("welcome")
	public String welcome() {
		return "Hello USER";
	}
}
