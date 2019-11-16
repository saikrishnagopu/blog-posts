package com.payment.serviceimpl;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.payment.Utils.ConstantUtils;
import com.payment.services.AccountCrudRepositoryService;
import com.payment.services.NotificationService;
import com.payment.services.TransactionCrudRepositoryService;
import com.payment.tasks.ScheduledTasks;


@Service
@PropertySource("classpath:application.properties")
public class NotificationServiceImpl implements NotificationService{
	
	private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	private final AccountCrudRepositoryService accountCrudRepositoryService;
	private final Environment environmnet;
	private final TransactionCrudRepositoryService transactionCrudRepositoryService;
    private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationServiceImpl(AccountCrudRepositoryService accountCrudRepositoryService, TransactionCrudRepositoryService transactionCrudRepositoryService, Environment environmnet, JavaMailSender javaMailSender){
		this.accountCrudRepositoryService = accountCrudRepositoryService;
		this.transactionCrudRepositoryService =  transactionCrudRepositoryService;
		this.javaMailSender = javaMailSender;
		this.environmnet = environmnet;	
	}

	@Override
	public void sendDailyRemainders() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.add(Calendar.HOUR, -24);
		Calendar toDate = Calendar.getInstance();
		List<String> dailyEmails =  transactionCrudRepositoryService.findDailyTransactionCount(fromDate.getTime());
		if (!CollectionUtils.isEmpty(dailyEmails)) {
			log.info("daily");
			dailyEmails.forEach(email -> {
				SimpleMailMessage mailMessage=new SimpleMailMessage();
				mailMessage.setTo(email);
		        mailMessage.setSubject("Gentle Remainder of your transactions");
		        mailMessage.setText(ConstantUtils.dailyReminder);
		        javaMailSender.send(mailMessage);
			});
		}
		
	}

	@Override
	public void sendHourlyEmails() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.add(Calendar.HOUR, -1);
		Calendar toDate = Calendar.getInstance();
		List<String> hourlyEmails =  transactionCrudRepositoryService.findHourlyTransactionCount(fromDate.getTime());
		if (!CollectionUtils.isEmpty(hourlyEmails)) {
			hourlyEmails.forEach(email -> {
				SimpleMailMessage mailMessage=new SimpleMailMessage();
				mailMessage.setTo(email);
		        mailMessage.setSubject("Gentle Remainder of your transactions");
		        mailMessage.setText(ConstantUtils.hourlyReminder);
		        javaMailSender.send(mailMessage);
			});
		}
	}

}
