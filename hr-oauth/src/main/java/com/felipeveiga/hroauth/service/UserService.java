package com.felipeveiga.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.hroauth.entities.User;
import com.felipeveiga.hroauth.feignclient.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User obj = userFeignClient.findByEmail(email).getBody();
		if(obj == null) {
			throw new IllegalArgumentException("Email not found");
		}
		return obj;
	}
}
