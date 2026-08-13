package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.UserDto;
import com.dcl.request.LoginRequest;
import com.dcl.request.RegisterRequest;
import com.dcl.service.UserService;

@RestController
@RequestMapping("/user")
public class DemoController {

	@Autowired
	private UserService uservice;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		UserDto dto=uservice.register(request);
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user registered",dto,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		UserDto dto=uservice.login(request);
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user registered",dto,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
}
