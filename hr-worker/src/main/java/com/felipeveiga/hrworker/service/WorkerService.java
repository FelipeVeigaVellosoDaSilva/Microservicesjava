package com.felipeveiga.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.hrworker.entities.Worker;
import com.felipeveiga.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repo;
	
	public List<Worker> findAll(){
		return repo.findAll();
	}
	
	public Worker findById(Long id){
		Worker obj = repo.findById(id).get();
		return obj;
	}
}
