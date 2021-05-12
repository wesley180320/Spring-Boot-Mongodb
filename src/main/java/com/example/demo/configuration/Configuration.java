package com.example.demo.configuration;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		 
		
	userRepository.deleteAll();
	
	
	User user = new User(null, "wesley","wesley@gmail");
	User user2 = new User(null, "maria","maria@gmail");
	User user3 = new User(null, "jessica","jessica@gmail");
	
	
	userRepository.saveAll(Arrays.asList(user,user2,user3));
	
	}

	
}
