package com.example;

import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

enum States {
	BACKLOG, IN_PROGRESS, TESTING, DONE
}

enum Events {
	START_FEATURE, FINISH_FEATURE, QA_REJECTED_UC, ROCK_STAR_DOUBLE_TASK, DEPLOY, QA_CHECKED_UC, QA_TEAM_REJECT,
	QA_TEAM_APPROVE, ROCK_STAR_MAKE_ALL_IN_ONE,
}

@Configuration
@EnableStateMachine
public class SimpleStateMachineConfiguration extends EnumStateMachineConfigurerAdapter<States, Events> {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
		config.withConfiguration().listener(listener()).autoStartup(true);
	}

	@Override
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states.withStates().initial(States.BACKLOG).state(States.IN_PROGRESS).state(States.TESTING).end(States.DONE);
	}

//	private Action<States, Events> deployAction() {
//		return context -> {
//			log.warn("send email that feature is finished: {}", context.getEvent());
//		};
//	}

	

	private StateMachineListener<States, Events> listener() {
		return new StateMachineListenerAdapter<States, Events>() {
			@Override
			public void transition(Transition<States, Events> transition) {
				log.warn("move from:{} to:{}", ofNullableState(transition.getSource()),
						ofNullableState(transition.getTarget()));
			}

			@Override
			public void eventNotAccepted(org.springframework.messaging.Message<Events> event) {
				log.error("event not accepted: {}", event);
			}

			private Object ofNullableState(State s) {
				return Optional.ofNullable(s).map(State::getId).orElse(null);
			}
		};
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		transitions. //
				withExternal() //
				.source(States.BACKLOG).target(States.IN_PROGRESS).event(Events.START_FEATURE).action(startFeature()) //
				.and().withExternal() //
				.source(States.IN_PROGRESS).target(States.TESTING).event(Events.FINISH_FEATURE).guard(checkDeployGuard())
				.and().withExternal() //
				.source(States.TESTING).target(States.IN_PROGRESS).event(Events.QA_TEAM_REJECT) //
				.and().withExternal() //
				.source(States.TESTING).target(States.DONE).event(Events.QA_TEAM_APPROVE).action(sendEmailOk()) //
				.and().withExternal() //
				.source(States.BACKLOG).target(States.TESTING).guard(checkDeployGuard())
				.event(Events.ROCK_STAR_MAKE_ALL_IN_ONE)
				
				/////
				.and()
				.withInternal()
		           .source(States.BACKLOG)
		           .event(Events.DEPLOY) 
		           .action(deployAction())
		           .and()
		           .withInternal()
		           .source(States.IN_PROGRESS)
		           .event(Events.DEPLOY) 
		           .action(deployAction());
	}
	
	
	private Action<States, Events> deployAction() {
		return context -> {
			log.warn("DEPLOYING: {}", context.getEvent());
			context.getExtendedState().getVariables().put("deployed", true);
		};
	}

	private Guard<States, Events> checkDeployGuard() {
		return context -> {
			Boolean flag = (Boolean) context.getExtendedState().getVariables().get("deployed");
			return flag == null ? false : flag;
		};
	}

	private Action<States, Events> startFeature() {
		return context -> {
			log.warn("start feature: {}", context.getEvent());
		};
	}

	private Action<States, Events> sendEmailOk() {
		return context -> {
			log.warn("send email that all is done: {}", context.getEvent());
		};
	}

}
