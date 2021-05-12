package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository rep;

	public List<User> findAll() {

		return rep.findAll();

	}
}
