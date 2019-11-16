package com.payment.services;


import com.payment.beans.PaymentRequestBean;
import com.payment.models.Account;


public interface AccountService {
	
	Account saveAccountFromRequest(PaymentRequestBean requestBean);

}
