package com.learn.springbootsecuritylearn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.springbootsecuritylearn.model.CustomUserDetail;
import com.learn.springbootsecuritylearn.model.User;
import com.learn.springbootsecuritylearn.repository.UserRepository;
@Service
//internally use spring security to load user
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = this.userRepository.findByUsername(username);
	    if(user == null) {
	    	throw new UsernameNotFoundException("NO USER");
	    }
	    
		return new CustomUserDetail(user);
	}
}