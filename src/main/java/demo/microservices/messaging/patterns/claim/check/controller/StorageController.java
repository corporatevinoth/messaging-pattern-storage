package demo.microservices.messaging.patterns.claim.check.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.microservices.messaging.patterns.claim.check.service.StorageService;


@RestController
public class StorageController {

	private StorageService storageService;
	
	public StorageController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@PostMapping("/storage/receive")
	public String receiveMessage(@RequestBody String payload) {
		return storageService.save(payload);
	}
	
	@GetMapping("/storage/get/{id}")
	public ResponseEntity<?> getMessage(@PathVariable String id) {
		return ResponseEntity.ok(storageService.retrieve(id));
	}
	
	// '/messages/id1,id2'
	
}
