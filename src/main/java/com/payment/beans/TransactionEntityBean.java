package com.payment.beans;

public class TransactionEntityBean {

	private String created_at;
	
	private String user_email;
	
	private Long inc_id;
	
	private String transaction_id;
	
	private Double amount;
	
	private String action;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Long getInc_id() {
		return inc_id;
	}

	public void setInc_id(Long inc_id) {
		this.inc_id = inc_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
}
