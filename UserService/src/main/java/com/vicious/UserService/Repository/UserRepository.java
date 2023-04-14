package com.vicious.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicious.UserService.Entity.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Long>{

	UserRegistration findByusername(String username);
}
