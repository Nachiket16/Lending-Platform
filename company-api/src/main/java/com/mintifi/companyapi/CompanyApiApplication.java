package com.mintifi.companyapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompanyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}


}
