package com.boot.doa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boot.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	//These are custom functions to query database
	//JPA automatically configures query by just looking name of the function
	//you just have to mention findBy and after that the property of your entity
	//you can even write your custom queries in JPA using @Query
	
	User findByName(String name);
	
	//This is custom query
	//select * from user order by name
	//As select * is constant so we can eliminate it
	//findAll is the design and after that u can write feature
	@Query("from User order by name")
	List<User> findAllSorted();
	
	//method to return values greater than passed id
	List<User> findByIdGreaterThan(int id);
}
