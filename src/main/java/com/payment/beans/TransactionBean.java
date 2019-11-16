package com.payment.beans;

public class TransactionBean {

	private String type;
	
	private TransactionEntityBean data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TransactionEntityBean getData() {
		return data;
	}

	public void setData(TransactionEntityBean data) {
		this.data = data;
	}
	
}
