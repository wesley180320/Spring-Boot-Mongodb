package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository rep;

	public List<User> findAll() {

		return rep.findAll();

	}

	public User findById(String id) {

		Optional<User> obj = rep.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {

		return rep.insert(obj);
	}

	public void Delete(String id) {

		rep.deleteById(id);

	}

	public User fromDto(UserDTO objDTO) {

		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());

	}

	


}
