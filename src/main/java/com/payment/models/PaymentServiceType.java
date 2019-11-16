package com.payment.models;

public enum PaymentServiceType {

	payment_service("Payment Service");
	
	private String displayName; 
	
	PaymentServiceType(String displayName){
		this.setDisplayName(displayName);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
