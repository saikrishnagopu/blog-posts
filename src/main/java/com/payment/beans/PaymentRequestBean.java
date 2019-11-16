package com.payment.beans;

import java.util.logging.Logger;

import com.payment.models.Account;
import com.payment.models.PaymentServiceType;
import com.payment.models.ServiceType;
import com.payment.models.Transaction;

public class PaymentRequestBean {
	
	private static Logger log = Logger.getLogger(PaymentRequestBean.class.getName());
	
	private String from_service_name;
	
	private TransactionBean data;


	public TransactionBean getData() {
		return data;
	}

	public void setData(TransactionBean data) {
		this.data = data;
	}

	public String getFrom_service_name() {
		return from_service_name;
	}

	public void setFrom_service_name(String from_service_name) {
		this.from_service_name = from_service_name;
	}
	
	public Transaction fromRequestBean() {
		log.info(this.getFrom_service_name());
		PaymentServiceType paymentServiceType = PaymentServiceType.valueOf(this.getFrom_service_name());
		
		switch(paymentServiceType) {
			case payment_service:
				TransactionBean transactionBean = this.getData();
				ServiceType serviceType = ServiceType.valueOf(transactionBean.getType());
				if(ServiceType.transaction.equals(serviceType)) {
					TransactionEntityBean transactionEntityBean = transactionBean.getData();
					Transaction transaction = new Transaction(transactionEntityBean);
					return transaction;
				}
				break;
			default:
				// no - op
		
		}
		return null;
	}


}
