package com.CG.Compliment.Generator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComplimentGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplimentGeneratorApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
