package com.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.Entity.Role;
import com.security.Entity.UserOne;
import com.security.Repository.RoleRepository;
import com.security.Repository.UserOneRepository;

@Service
public class UserService {
    @Autowired
	private UserOneRepository userrepo;
    
    @Autowired
    private RoleRepository rolerepo;
	
    public UserOne saveUser(UserOne user) {
    	return userrepo.save(user);
    }
    
    public UserOne getbyid(long id) {
    	return userrepo.findById(id).get();
    }
    
    public Role saveRole(Role role) {
    	return rolerepo.save(role);
    }
}
