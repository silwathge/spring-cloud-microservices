package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.JwtUtil;
import com.example.demo.vo.UserVo;

@RestController
public class TestSecController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	

	@GetMapping("/welcome")
	public String welome() {
		
		return "Hi ";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody UserVo authRequest) {
		 try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
		} catch (AuthenticationException e) {
			throw e;
		}
		 
		 return jwtUtil.generateToken(authRequest.getUserName());
	}
}
