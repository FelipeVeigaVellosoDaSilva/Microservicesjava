package com.felipeveiga.hruser.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipeveiga.hruser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Transactional
	User findByEmail(String email);
	
}
