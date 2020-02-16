package com.fci.engaly;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@EnableScheduling               // it used start in tutorial 10
public class SpringBootTutorialApplication implements ApplicationRunner, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

	/**
	 * to call it in any way with AutoWired to consume restful web service you
	 * can call it in any place with autowired annotation it used in T5
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * this is scratch point when the server is running will type in the browser
	 * mentioned sentence (Hello World Spring boot). note that this method will
	 * work when index.html is absent.
	 * 
	 * @return
	 */
	// @RequestMapping("/")
	// public String helloWorld() {
	// return "<h1>Hello World Spring boot </h1>";
	// }

	/**
	 * ApplicationRunner is interface. explain Application Runner is an
	 * interface used to execute the code after the Spring Boot application
	 * started.
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// System.out.println("i run after spring boot started");

	}

	/**
	 * CommandLineRunner is an interface. It is used to execute the code after
	 * the Spring Boot application started.
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		// System.out.println("another method run after spring boot is start");

	}

}
