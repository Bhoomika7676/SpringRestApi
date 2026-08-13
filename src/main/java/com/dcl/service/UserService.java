package com.dcl.service;

import com.dcl.dto.UserDto;
import com.dcl.request.RegisterRequest;

public interface UserService {
	
	public UserDto register(RegisterRequest request);
}
