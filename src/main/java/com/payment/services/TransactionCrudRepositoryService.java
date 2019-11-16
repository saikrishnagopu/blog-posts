package com.payment.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.payment.Utils.ConstantUtils;
import com.payment.models.Account;
import com.payment.models.Transaction;


public interface TransactionCrudRepositoryService extends CrudRepository<Transaction, Long>{
	
	@Query(ConstantUtils.getAllTransactionQuery)
	Transaction findTransactionByEmail(@Param("transactionId") String transactionId);

	@Query(ConstantUtils.getDailyAccountRemainders)
	List<String> findDailyTransactionCount(@Param("fromDate") Date fromDate);

	@Query(ConstantUtils.getHourlyAccountRemainders)
	List<String> findHourlyTransactionCount(@Param("fromDate") Date fromDate);
	

}
