package com.security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

	Optional <Role> findByRoleName(String role);
	
}
