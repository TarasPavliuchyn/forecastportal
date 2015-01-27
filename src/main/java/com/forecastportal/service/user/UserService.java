package com.forecastportal.service.user;

import com.forecastportal.domain.user.User;

public interface UserService {

	User findByEmail(String email);

	User create(User created);

	User findById(Long userId);

	User findByEmailAndActivated(String email, Boolean activated);

	User save(User user);

	void activateUser(Long id);

}
