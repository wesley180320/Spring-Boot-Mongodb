package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class Resources {

	
	@Autowired
	private UserServices us;
	
	// Buscar todos os usuarios
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = us.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}

	// Buscar por ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User obj = us.findById(id);
	
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	
	// Inserir dados
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> findById(@RequestBody UserDTO objDTO){
		
		User obj = us.fromDto(objDTO) ;
	    
	    obj = us.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/(id)").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	
	// Deletar por id
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable String id){
			
			us.Delete(id);
		
			return ResponseEntity.noContent().build();
		}
	
		// Atualizar dados
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> findById(@RequestBody UserDTO objDTO,@PathVariable String id){
			
			User obj = us.fromDto(objDTO) ;
		    
			obj.setId(id);
		    
		    obj = us.update(obj);
			
		    return ResponseEntity.noContent().build();
		}
}
