package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaH2RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaH2RestApplication.class, args);
		
		/*
		 * We have created a Spring RestRepository, Spring JPA and H2 Database project
		 * It is a restful service which do CRUD operations using JpaRepository Interface
		 * We saw everything done automatically without writting Controller class
		 * Just Repository Interface handled everything.
		 * */
	}

}
