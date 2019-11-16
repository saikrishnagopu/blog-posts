# payment-service

1. Each user with different Email Id will have one account
2. Each Account Will have multiple transaction, whether its credit or debit.
3. Cron Job Running for both daily reminders and hourly remainders.

To save the transaction:
POST: vaccount/new
Content-Type, value:application/json"

{
	"from_service_name": "payment_service",
	"data":{
		"type": "transaction",
		"data":{
			"created_at": "121212121",
			"user_email": "saikrishnagopu@gmail.com",
			"inc_id": 12312121,
			"transaction_id": "trans130",
			"amount": 10000,
			"action": "debit"
		}
	}
}


And each transaction, transaction Id is unique.
