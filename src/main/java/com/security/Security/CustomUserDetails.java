package com.security.Security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.Entity.UserOne;
import com.security.Repository.UserOneRepository;

@Service
public class CustomUserDetails implements UserDetailsService{
    @Autowired
	private UserOneRepository userrepository;
    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserOne user = userrepository.findByEmail(email).get();
	Set<GrantedAuthority > authority = 	user.getRole()
										    .stream()
										    .map(role->new SimpleGrantedAuthority(role.getRoleName()))
										    .collect(Collectors.toSet());
		
	
		
		return new User(user.getEmail(),user.getPassword(),authority);
	}

}
