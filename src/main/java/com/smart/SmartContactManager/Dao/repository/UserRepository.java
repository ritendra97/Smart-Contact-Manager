package com.smart.SmartContactManager.Dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.smart.SmartContactManager.Models.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select u from u where u.email=:email") // Basically ye email mera parameter h aur yha pr dynamic email lana h 
	public User getuserByname(@Param("email") String email);
	
}
