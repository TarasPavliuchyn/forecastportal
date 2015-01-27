package com.forecastportal.util;

import com.forecastportal.domain.user.User;

public interface TokenService {
	public User getUserFromLink(String token);

	public String createToken(User u);

}
