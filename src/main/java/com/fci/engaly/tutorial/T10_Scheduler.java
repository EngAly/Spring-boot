package com.fci.engaly.tutorial;

import java.text.SimpleDateFormat;
import java.util.Date;

 import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduling is a process of executing the tasks for the specific time period.
 * Spring Boot provides a good support to write a scheduler on the Spring
 * applications. Java Cron expressions are used to configure the instances of
 * CronTrigger. please review Cron in linux will explain how its expression note
 * that to make Scheduler work perfect you must provide @EnableScheduling in
 * upper main class we will stop it from comment @EnableScheduling in
 * SpringApplication.run you can to uncomment to try it.
 */
@Component
public class T10_Scheduler {

	/**
	 * -------------------------- Cron Expression -----------------------------
	 * this method will executed every minute start from clock 17 PM until 17.59
	 * PM. so that you can execute task start from specific time
	 */
	@Scheduled(cron = "0 * 17 * * ?")
	public void jobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		 System.out.println("specifci time= " + strDate);
	}

	/**
	 * ----------------------------- Fixed Rate -----------------------------
	 * this method will executed every time all hours without any stopping in
	 * this example will execute every 30 seconds
	 */
	@Scheduled(fixedRate = 30000)
	public void jopSchFixed() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		 System.err.println("fixed time= "+strDate);
	}

	/**
	 * --------------------------------Fixed Delay ------------------------
	 * Here, the initialDelay is the time after which the task will be executed
	 * the first time after the initial delay value. An example to execute the
	 * task for every 15 second3 after 3 seconds from the application startup
	 * has been completed
	 */
	@Scheduled(fixedDelay = 15000, initialDelay = 3000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Fixed Delay scheduler:: " + strDate);
	}
}
