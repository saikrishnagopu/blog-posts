package com.payment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.payment.beans.PaymentRequestBean;
import com.payment.models.Account;
import com.payment.models.Transaction;
import com.payment.services.AccountCrudRepositoryService;
import com.payment.services.AccountService;
import com.payment.services.TransactionCrudRepositoryService;


@Service
@PropertySource("classpath:application.properties")
public class AccountServiceImpl implements AccountService{
	
	private final AccountCrudRepositoryService accountCrudRepositoryService;
	private final Environment environmnet;
	private final TransactionCrudRepositoryService transactionCrudRepositoryService;
	
	@Autowired
	public AccountServiceImpl(AccountCrudRepositoryService accountCrudRepositoryService, TransactionCrudRepositoryService transactionCrudRepositoryService, Environment environmnet){
		this.accountCrudRepositoryService = accountCrudRepositoryService;
		this.transactionCrudRepositoryService =  transactionCrudRepositoryService;
		this.environmnet = environmnet;	
	}


	@Override
	public Account saveAccountFromRequest(PaymentRequestBean requestBean) {	
		Transaction transaction = requestBean.fromRequestBean();
		transactionCrudRepositoryService.save(transaction);
		Account account = accountCrudRepositoryService.findAccountByEmail(transaction.getUserEmail());
		if(account == null) {
			 account = new Account(transaction.getUserEmail());
			 account.addTransaction(transaction);
			 accountCrudRepositoryService.save(account);
			 return account;
		}
		account.addTransaction(transaction);
		accountCrudRepositoryService.save(account);
		return account;
	}


}
