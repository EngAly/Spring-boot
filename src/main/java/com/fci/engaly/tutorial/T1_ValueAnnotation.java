package com.fci.engaly.tutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * --------------------------independent------------------------
 * RestController annotation is used to define the RESTful web services
 */
@RestController
@RequestMapping("/app")
public class T1_ValueAnnotation {

	// get spring.application.name attribute in application.properties and
	// assign it to appName variable
	@Value("${spring.application.name:SpringBoot}")
	private String appName;

	@RequestMapping("/appname")
	public String getApllicationName() {
		return "<h1>Apllication Name: </h1>" + appName;

	}

}
