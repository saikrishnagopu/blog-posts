package com.payment.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.payment.Utils.ConstantUtils;
import com.payment.models.Account;


public interface AccountCrudRepositoryService extends CrudRepository<Account, Long>{
	
	
	@Query(ConstantUtils.getAllAccounts)
	Account findAccountByEmail(@Param("userEmail") String userEmail);
	
	
}