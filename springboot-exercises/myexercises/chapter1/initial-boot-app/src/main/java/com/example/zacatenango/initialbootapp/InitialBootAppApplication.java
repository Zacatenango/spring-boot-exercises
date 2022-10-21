package com.example.zacatenango.initialbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Our Spring Boot application starts with a one-liner that can be already run and browsed by means of the entire
// Spring suite. In our psvmSa, we tell Spring to just up and run the entire application.
@SpringBootApplication public class InitialBootAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(InitialBootAppApplication.class, args);
	}

	// We can define an entire REST API by just declaring a subclass in our main application class annotated with
	// @RestController @RequestMapping("/<URL>")
	// Note: to change our listening port, we define server.port=<port> in application.properties, or server: port: on
	// application.yml
	@RestController @RequestMapping("/api") public class APIController
	{
		// To define an API GET endpoint, we define a function that returns String annotated with @GetMapping("/<URL>")
		@GetMapping("/greeting") public String getGreeting()
		{
			return "REST API message says mogu mogu~";
		}
	}
}
