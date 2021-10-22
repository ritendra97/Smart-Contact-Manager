package com.smart.SmartContactManager.configue;


import com.smart.SmartContactManager.Dao.repository.UserRepository;
import com.smart.SmartContactManager.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.SmartContactManager.Dao.repository.UserRepository;

public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Fetching data from database
		User user = (User) userRepository.getuserByname(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not found user");
		}
		
		CustomeUserDetails customuserdetails = new CustomeUserDetails(user);
		
		return customuserdetails;
	}

}
