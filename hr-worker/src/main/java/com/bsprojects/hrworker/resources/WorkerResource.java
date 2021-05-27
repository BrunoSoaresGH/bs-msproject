package com.bsprojects.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsprojects.hrworker.entities.Worker;
import com.bsprojects.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> getWorkers(){
		List<Worker> workersList = repository.findAll();
		return ResponseEntity.ok(workersList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getWorkerById(@PathVariable Long id){
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
	
}
