package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceJpAwithH2Application {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceJpAwithH2Application.class, args);
		
		/* we have used Spring Web, JPA and H2 in this project,
		 * We are using CrudRepository Interface of JPA and performing CRUD ops on a model
		 * We have saw multiple functionality and also saw REST CONTROLLER as well
		 */
	}

}
