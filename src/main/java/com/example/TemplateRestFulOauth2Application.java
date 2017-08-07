package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.config.CustomUserDetails;
import com.example.dao.UserRepository;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;

//@EnableAutoConfiguration
@SpringBootApplication
public class TemplateRestFulOauth2Application {

	// http://localhost:8081/templateRestFulOauth2/oauth/token?grant_type=password&username=user&password=user
	// http://localhost:8081/templateRestFulOauth2/persons?access_token=d6c3dfe9-bdf2-4978-b008-1f1ffbb78ad3
	// http://localhost:8081/templateRestFulOauth2/oauth/token?grant_type=refresh_token&refresh_token=dfea499c-0eb8-4394-8c25-a7af5b1aa3d9
	 
	// admin
	// http://localhost:9000/admin/metrics
	// http://localhost:9000/admin/trace
	// http://localhost:9000/admin/env
	// http://localhost:9000/admin/beans
	// http://localhost:9000/admin/dump
	// http://localhost:9000/admin/mappings
	// ssh -p 2000 user@127.0.0.1
	// dashboard
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TemplateRestFulOauth2Application.class, args);
	}
	
	
	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we coded.
	 * @param builder
	 * @param repository
	 * @throws Exception
     */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
		//Setup a default user if db is empty
		if (repository.count()==0)
			service.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}

	/**
	 * We return an istance of our CustomUserDetails.
	 * @param repository
	 * @return
     */
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
	
}




