package com.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.firstapp.beans.User;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  context = SpringApplication.run(FirstAppApplication.class, args);
		
		User user = context.getBean(User.class);
		
		
	}

}
