package com.forecastportal.service.user;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.forecastportal.repository.user.UserRepository;

@Service
public class AuthServiceImpl implements UserDetailsService {

	@Resource
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		com.forecastportal.domain.user.User user = userRepository.findByEmailAndActivated(email, Boolean.TRUE);
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority customerAuthority = new SimpleGrantedAuthority(
				"ROLE_USER");
		SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(
				"ROLE_ADMIN");
		if (user.getRole().toString().equals("CUSTOMER")) {
			authorities.add(customerAuthority);
		} else if (user.getRole().toString().equals("ADMIN")) {
			authorities.add(customerAuthority);
			authorities.add(adminAuthority);
		}
		UserDetails userDetails = new CustomUserDetailsService(user, true, true, true, true, authorities);
		return userDetails;
	}
}