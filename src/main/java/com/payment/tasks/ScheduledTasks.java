package com.payment.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.payment.services.NotificationService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private NotificationService NotificationService;

	@Scheduled(cron = "0 0 * * * *")
//	@Scheduled(fixedRate = 10000)
	public void sendHourlyNotifications() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		try {
			NotificationService.sendHourlyEmails();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0 0 8 * * *")
//	@Scheduled(fixedRate = 10000)
	public void reportDailyNotifications() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		try {
			NotificationService.sendDailyRemainders();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
