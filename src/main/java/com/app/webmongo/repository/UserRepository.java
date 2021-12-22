package com.app.webmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.webmongo.model.User;
import com.app.webmongo.repository.crud.UserCrudRepository;

public class UserRepository {
	
	@Autowired
	private UserCrudRepository userCrudRepository;

	public List<User> getAllUsers() {
		return userCrudRepository.findAll();
	}
	
	public Optional<User> getUser(Integer id) {
		return userCrudRepository.findById(id);
	}

	public boolean emailExist(String email) {
		Optional<User> user = userCrudRepository.findByEmail(email);
		return user.isPresent();
	}

	public User save(User user) {
		return userCrudRepository.save(user);
	}

	public Optional<User> authenticateUser(String email, String password) {
		Optional<User> user = userCrudRepository.findByEmailAndPassword(email, password); 
		return user;
	}

	public void update(User user) {
		userCrudRepository.save(user);
	}

	public void delete(User user) {
		userCrudRepository.delete(user);
	}



}
