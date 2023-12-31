package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepo uR = context.getBean(UserRepo.class);
		
		User user = new User();
		user.setName("Soumya Ranjan Panda");
		user.setCity("Moter");
		user.setId(1);
		user.setStatus("Java Programmer");
		
		User user1 = uR.save(user);
		List<User> users = List.of(user);
		System.out.println(user1);
		
	}

}
