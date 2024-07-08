package com.security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.Entity.UserOne;

public interface UserOneRepository extends JpaRepository<UserOne,Long>{

	Optional <UserOne> findByEmail(String email);
	
	Boolean existsByEmail(String email);
}
