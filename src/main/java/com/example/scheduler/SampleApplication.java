package com.example.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		return scheduler;
	}
}
