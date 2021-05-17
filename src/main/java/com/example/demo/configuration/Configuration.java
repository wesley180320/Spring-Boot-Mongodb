package com.example.demo.configuration;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		
	userRepository.deleteAll();
	postRepository.deleteAll();
	
	User user = new User(null, "wesley","wesley@gmail");
	User user2 = new User(null, "maria","maria@gmail");
	User user3 = new User(null, "jessica","jessica@gmail");
	
	
	Post p1 = new Post(null, sdf.parse("12/03/2021"), "viagem", "to indo para campo grande", user3);
	
	
	userRepository.saveAll(Arrays.asList(user,user2,user3));
	postRepository.save(p1);
	
	}

	
}
