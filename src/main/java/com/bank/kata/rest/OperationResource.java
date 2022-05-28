package com.bank.kata.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bank.kata.domain.Operation;
import com.bank.kata.service.OperationService;

@RestController
@RequestMapping("/api/operations")
public class OperationResource {
	
	private final OperationService operationService;

	public OperationResource(OperationService operationService) {
		this.operationService = operationService;
	}


	@GetMapping()
	public ResponseEntity<List<Operation>> getAllOperations(@RequestParam("accountId") Long accountId) {
		
		List<Operation> operations = operationService.findOperations(accountId);
		
		return new ResponseEntity<>(operations, HttpStatus.OK);
		
	}

}
