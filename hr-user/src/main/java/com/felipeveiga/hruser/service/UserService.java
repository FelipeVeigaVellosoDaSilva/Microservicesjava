package com.felipeveiga.hruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.hruser.entities.User;
import com.felipeveiga.hruser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User findById(Long id){
		User obj = repo.findById(id).get();
		return obj;
	}
	
	public User findByEmail(String email){
		User obj = repo.findByEmail(email);
		return obj;
	}
}
