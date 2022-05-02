package com.felipeveiga.hroauth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipeveiga.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user")
public interface UserFeignClient {

	@GetMapping("/users/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
	
}
