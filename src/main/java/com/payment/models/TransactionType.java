package com.payment.models;

public enum TransactionType {
	
	credit("Credit"),
	debit("Debit");
	
	private String displayName;
	
	
	TransactionType(String displayName){
		this.setDisplayName(displayName);
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
