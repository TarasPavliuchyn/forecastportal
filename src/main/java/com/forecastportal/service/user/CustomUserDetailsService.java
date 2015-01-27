package com.forecastportal.service.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomUserDetailsService extends
		org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private com.forecastportal.domain.user.User user;

	public CustomUserDetailsService(com.forecastportal.domain.user.User user,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getFname(), user.getPassword(), authorities);
		this.user = user;
	}

	public CustomUserDetailsService(com.forecastportal.domain.user.User user,
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<SimpleGrantedAuthority> authorities) {
		super(user.getFname(), user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.user = user;
	}

	public com.forecastportal.domain.user.User getUser() {
		return user;
	}

	public void setUser(com.forecastportal.domain.user.User user) {
		this.user = user;
	}
}
