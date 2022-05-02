package com.felipeveiga.hroauth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipeveiga.hroauth.entities.User;
import com.felipeveiga.hroauth.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping("users/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = userService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
}
