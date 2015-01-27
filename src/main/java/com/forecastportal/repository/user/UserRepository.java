package com.forecastportal.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.forecastportal.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String mail);

	User findByEmailAndActivated(String mail, Boolean activated);

	User findById(Long userId);

	List<User> findAll();

	@Modifying
	@Query(value = "update User u set u.activated = true where u.id = ?1", nativeQuery = true)
	void activateUser(Long id);
}
