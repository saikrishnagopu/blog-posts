package com.payment.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.payment.beans.PaymentRequestBean;
import com.payment.models.ServiceType;
import com.payment.models.Account;
import com.payment.services.AccountCrudRepositoryService;
import com.payment.services.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountCrudRepositoryService accountCrudRepositoryService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	Environment environmnet;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/vaccount/new", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public @ResponseBody ResponseEntity<Account> addAccountAndGetResponse(@RequestBody PaymentRequestBean input, HttpServletRequest request) {
		try{
			Account account = accountService.saveAccountFromRequest(input);
			return ResponseEntity.accepted().body(account);
		} catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	
	
}
