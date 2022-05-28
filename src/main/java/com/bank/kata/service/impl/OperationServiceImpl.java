package com.bank.kata.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.bank.kata.domain.Operation;
import com.bank.kata.repository.OperationRepository;
import com.bank.kata.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {
	
	private final OperationRepository operationRepository;

	public OperationServiceImpl(OperationRepository operationRepository) {
		this.operationRepository = operationRepository;
	}

	@Override
	public List<Operation> findOperations(Long accountId) {
		return operationRepository.findOperationsByAccountId(accountId);
	}

}
