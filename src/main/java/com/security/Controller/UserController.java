package com.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.Dto.LoginDto;
import com.security.Dto.RegisterDto;
import com.security.Entity.Role;
import com.security.Entity.UserOne;
import com.security.Service.AuthService;
import com.security.Service.UserService;

@RestController
public class UserController {
    @Autowired
	private UserService userservice;
    @Autowired
    private AuthService authservice;
    
    @PostMapping("/insecure/auth") //use post instead of get pass in url
    public ResponseEntity<String>  login(@RequestBody LoginDto logindto){
    	
    	return new ResponseEntity<>( authservice.login(logindto),HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<UserOne> saveUser(@RequestBody UserOne user){
    	UserOne saved = userservice.saveUser(user);
    	return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    
    @GetMapping("/insecure/home")
    public String Home() {
    	
    	return "welcome to this page ";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserOne>  getbyid(@PathVariable("id")int id){
    	UserOne user = userservice.getbyid(id);
    	return new ResponseEntity<>(user,HttpStatus.OK);
    }
    
    @PostMapping("/insecure/role")
   public Role saveRole(@RequestBody Role role) {
	 return   userservice.saveRole(role);
   }
    
    @PostMapping("/insecure/register")
    public String Register(@RequestBody RegisterDto registerdto) {
    	String register = authservice.Register(registerdto);
    	return register;
    }
}
