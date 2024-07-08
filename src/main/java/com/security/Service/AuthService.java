package com.security.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.Dto.LoginDto;
import com.security.Dto.RegisterDto;
import com.security.Entity.Role;
import com.security.Entity.UserOne;
import com.security.Exception.EmployeeAlreadyExistException;
import com.security.Repository.RoleRepository;
import com.security.Repository.UserOneRepository;

@Service
public class AuthService {

	@Autowired
    private UserOneRepository userrepo;
	@Autowired
    private RoleRepository rolserepo;
	@Autowired
	private PasswordEncoder passwordencoder;
	
	
	
	
//	public AuthService(UserOneRepository userrepo, RoleRepository rolserepo, PasswordEncoder passwordencoder,
//			AuthenticationManager authenticationmanager) {
//		super();
//		this.userrepo = userrepo;
//		this.rolserepo = rolserepo;
//		this.passwordencoder = passwordencoder;
//		this.authenticationmanager = authenticationmanager;
//	}

	//-----
	
	
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    public String login(LoginDto loginDto) {
	        try {
	          
	            Authentication auth = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

	            SecurityContextHolder.getContext().setAuthentication(auth);

	            return "login successful";
	        } catch (AuthenticationException e) {
	            // Authentication failed
	            return "login failed: " + e.getMessage();
	        }
	    }
	

	
	
	//----

	

	public String Register(RegisterDto registerdto) {
		
		if(userrepo.existsByEmail(registerdto.getEmail())) {
			throw new EmployeeAlreadyExistException("employee already exists");
		}
		UserOne user = new UserOne();
		user.setEmail(registerdto.getEmail());
		user.setName(registerdto.getName());
		user.setPassword(passwordencoder.encode(registerdto.getPassword()));
		
		Set<Role> role = new HashSet<Role>();
		Role r = rolserepo.findByRoleName("user").get();
		role.add(r);
		user.setRole(role);
		userrepo.save(user);
		return "Register Sucessfull";
	}
}
