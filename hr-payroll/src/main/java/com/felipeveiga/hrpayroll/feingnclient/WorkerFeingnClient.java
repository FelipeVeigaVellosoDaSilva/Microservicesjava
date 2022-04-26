package com.felipeveiga.hrpayroll.feingnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.felipeveiga.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeingnClient {

	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
