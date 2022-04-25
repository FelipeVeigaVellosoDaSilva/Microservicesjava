package com.felipeveiga.hrworker.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.felipeveiga.hrworker.entities.Worker;
import com.felipeveiga.hrworker.service.WorkerService;

@RestController
public class WorkerResource {

	@Autowired
	private WorkerService service;
	
	@GetMapping("/workers")
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/workers/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
