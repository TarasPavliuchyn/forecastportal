package com.forecastportal.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forecastportal.domain.user.User;
import com.forecastportal.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	public UserRepository userRepository;

	@Transactional
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Transactional
	public User create(User created) {
		return userRepository.save(created);
	}

	@Transactional
	public User findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Transactional
	public User findByEmailAndActivated(String email, Boolean activated) {
		return userRepository.findByEmailAndActivated(email, activated);
	}

	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public void activateUser(Long id) {
		userRepository.activateUser(id);
	}

}
