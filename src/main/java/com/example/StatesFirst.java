package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StatesFirst {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    Logger log=LoggerFactory.getLogger(StatesFirst.class);
    @GetMapping
    public void initTest() {
       
    }
}
