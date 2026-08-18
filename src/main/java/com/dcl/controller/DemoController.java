package com.dcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.UserDto;
import com.dcl.request.LoginRequest;
import com.dcl.request.RegisterRequest;
import com.dcl.request.UpdateRequest;
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
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Integer userId){
		UserDto dto=uservice.getUserById(userId);
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user found",dto,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		List<UserDto> dto=uservice.getAll();
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user found",dto,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable Integer userId){
		uservice.deleteById(userId);
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user deleted",null,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Integer userId,@RequestBody UpdateRequest request){
		UserDto dto=uservice.updateUser(userId, request);
		com.dcl.response.ApiResponse<?> response=new com.dcl.response.ApiResponse<>("user deleted",null,HttpStatus.CONFLICT );
		return ResponseEntity.ok(response);
		
	}
}
