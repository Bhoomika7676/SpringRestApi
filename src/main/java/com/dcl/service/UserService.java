package com.dcl.service;

import java.util.List;

import com.dcl.dto.UserDto;
import com.dcl.request.LoginRequest;
import com.dcl.request.RegisterRequest;
import com.dcl.request.UpdateRequest;

public interface UserService {
	
	public UserDto register(RegisterRequest request);
	
	public UserDto login(LoginRequest request);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAll();
	
	public void deleteById(Integer userId);
	
	public UserDto updateUser(Integer userId,UpdateRequest request);
	
}
