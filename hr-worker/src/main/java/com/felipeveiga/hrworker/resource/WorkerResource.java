package com.felipeveiga.hrworker.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.felipeveiga.hrworker.entities.Worker;
import com.felipeveiga.hrworker.service.WorkerService;

@RefreshScope
@RestController
public class WorkerResource {

	private static Logger Logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerService service;
	@Autowired
	private Environment env;
	
	@GetMapping("/workers")
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/workers/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		Logger.info("PORT= " + env.getProperty("local.server.port"));
		
		Worker obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/workers/configs")
	public ResponseEntity<Void> getCongs(){
		Logger.info("Config = " + testConfig);
		return ResponseEntity.noContent().build();
	}
}
