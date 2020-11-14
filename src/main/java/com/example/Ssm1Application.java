package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class Ssm1Application implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	Logger log = LoggerFactory.getLogger(StatesFirst.class);

	public static void main(String[] args) {
		SpringApplication.run(Ssm1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception { 
//		log.warn(stateMachine.getState().getId().toString());
//		log.warn(stateMachine.isComplete());
//		System.out.println(stateMachine.isComplete());
//		stateMachine.sendEvent(Events.START_FEATURE);
//		stateMachine.sendEvent(Events.FINISH_FEATURE);
		
//		stateMachine.sendEvent(Events.START_FEATURE);
//		
//		stateMachine.sendEvent(Events.FINISH_FEATURE);
////		stateMachine.sendEvent(Events.DEPLOY);
//		stateMachine.sendEvent(Events.QA_TEAM_REJECT);
//		stateMachine.sendEvent(Events.ROCK_STAR_MAKE_ALL_IN_ONE);
		
//		stateMachine.sendEvent(Events.START_FEATURE);
		log.warn(stateMachine.getState().getId().toString());
		stateMachine.sendEvent(Events.DEPLOY); 
	    stateMachine.sendEvent(Events.ROCK_STAR_MAKE_ALL_IN_ONE);
	    stateMachine.sendEvent(Events.QA_TEAM_APPROVE);
		

		
		
//		log.warn(stateMachine.getState().getId().toString());
//	    stateMachine.sendEvent(Events.FINISH_FEATURE);
//	    log.warn(stateMachine.getState().getId().toString());
		
	}

}
