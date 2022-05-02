package com.felipeveiga.hruser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipeveiga.hruser.entities.User;
import com.felipeveiga.hruser.service.UserService;

@RestController
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/users/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		User obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
}
