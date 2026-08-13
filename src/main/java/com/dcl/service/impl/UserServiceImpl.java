package com.dcl.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dto.UserDto;
import com.dcl.entity.User;
import com.dcl.repository.UserRepo;
import com.dcl.request.LoginRequest;
import com.dcl.request.RegisterRequest;
import com.dcl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDto register(RegisterRequest request) {
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyExists!=null) {
			throw new RuntimeException("account already exists");
		}
		
		User user=new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user=urepo.save(user);
		
		UserDto dto=new UserDto();
		dto.setEmail(user.getEmail());
		dto.setCreatedAt(user.getCreatedAt());
		dto.setUserId(user.getUserId());
		return dto;
	}
	@Override
	public UserDto login(LoginRequest request) {
		//validating user is existing user or not
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("User Not Found"));
		
		if(!alreadyExists.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("Incorrect Password!");
		}
		
		UserDto dto=mapper.map(alreadyExists,UserDto.class);
		
		return dto;
	}
	
	

}
