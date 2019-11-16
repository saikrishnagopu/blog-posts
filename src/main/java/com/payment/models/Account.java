package com.payment.models;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends BaseEntity{
	
	@Column(unique = true)
	private String userEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	protected Account() {}

	public Account(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		if(transaction == null) {
			return;
		}
		this.transactions.add(transaction);	
	}
	
}
