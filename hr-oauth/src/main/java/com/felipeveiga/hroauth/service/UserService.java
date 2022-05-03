package com.felipeveiga.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.felipeveiga.hroauth.entities.User;
import com.felipeveiga.hroauth.feignclient.UserFeignClient;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User obj = userFeignClient.findByEmail(email).getBody();
		if(obj == null) {
			throw new IllegalArgumentException("Email not found");
		}
		return obj;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User obj = userFeignClient.findByEmail(username).getBody();
		if(obj == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return obj;	
	}
}
