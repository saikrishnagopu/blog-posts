package com.payment.Utils;

public class ConstantUtils {
	

	public static final String getDailyAccountRemainders = "SELECT t.userEmail FROM Transaction t where t.transactionType = 1 AND createdOn > :fromDate GROUP BY t.userEmail HAVING COUNT(t.amount) > 10000";
	
	public static final String getHourlyAccountRemainders = "SELECT t.userEmail FROM Transaction t where createdOn > :fromDate GROUP BY t.userEmail HAVING COUNT(t.id) > 3";
	
	public static final String getAllTransactionQuery = "SELECT t FROM Transaction t where t.transactionId = :transactionId";
	
	public static final String getAllAccounts = "SELECT t FROM Account t where t.userEmail = :userEmail";
	
	
	public static final String dailyReminder = "Hi,\n  This is a daily reamainder that total amount debited from your account is more than 10000.";
	
	public static final String hourlyReminder = "Hi,\n This is a hourly reamainder that you have been transacting frequently, which is more than 3 times in past 1 hour.";
	

}
