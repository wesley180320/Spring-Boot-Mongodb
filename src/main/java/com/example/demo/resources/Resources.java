package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
@RequestMapping(value="/users")
public class Resources {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = new ArrayList<>();
		User maria = new User(1, "maria", "maria@gmail.com");
		User wesley = new User(1, "wesley", "wesley@gmail.com");

		list.addAll(Arrays.asList(maria, wesley));

		return ResponseEntity.ok().body(list);
	}
}
