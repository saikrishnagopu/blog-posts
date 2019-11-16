package com.payment.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.payment.beans.TransactionEntityBean;

@Entity
public class Transaction extends BaseEntity{
	
	private String createdAt;
	
	private String userEmail;
	
	private Long incId;
	
	@Column(unique = true)
	private String transactionId;
	
	private Double amount;
	
	private TransactionType transactionType;
	
	public Transaction() { 
		
	}
	
	public Transaction(TransactionEntityBean transactionEntityBean) {
		this.createdAt = transactionEntityBean.getCreated_at();
		this.userEmail = transactionEntityBean.getUser_email();
		this.incId = transactionEntityBean.getInc_id();
		this.transactionId = transactionEntityBean.getTransaction_id();
		this.amount = transactionEntityBean.getAmount();
		this.transactionType = TransactionType.valueOf(transactionEntityBean.getAction());	
	}


	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getIncId() {
		return incId;
	}

	public void setIncId(Long incId) {
		this.incId = incId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
