package com.bank.kata.repository;

import com.bank.kata.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
	
    List<Operation> findOperationsByAccountId(Long accountId);

}
