package com.security.Dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
	
public static void main(String[] args) {
	PasswordEncoder s = new BCryptPasswordEncoder();
	System.out.println(s.encode("nithya1234"));
	
}
}
