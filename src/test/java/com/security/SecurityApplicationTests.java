package com.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.security.Entity.UserOne;
import com.security.Repository.UserOneRepository;

@SpringBootTest
class SecurityApplicationTests {
@Autowired
	private UserOneRepository user ;
//	@Test
//	void contextLoads() {
//	UserOne users= 	 user.findByName("kumar").get();
//	System.out.println(users);
//	}
	@Test
	public void existbyemail() {
	
		System.out.println(user.existsByEmail("kumar@gmail.com"));
		}

}
