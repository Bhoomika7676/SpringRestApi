package com.dcl.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import lombok.SneakyThrows;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	
}
