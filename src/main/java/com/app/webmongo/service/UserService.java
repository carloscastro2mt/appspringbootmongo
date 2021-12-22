package com.app.webmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.webmongo.model.User;
import com.app.webmongo.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public Optional<User> getUser(Integer id) {
		return userRepository.getUser(id);
	}
	
	public boolean emailExist(String email) {
		return userRepository.emailExist(email);
	}
	
	public User registrateUser(User user) {
		Optional<User> dbUser = userRepository.getUser(user.getId()); 
		if(dbUser.isEmpty() && emailExist(user.getEmail()) == false) {
			return userRepository.save(user);
		}else
			return user;
		
	}

	public User authenticateUser(String email, String password) {
		Optional<User> user = userRepository.authenticateUser(email, password);
		if(user.isEmpty()) {
			return new User(null, null, "NO DEFINIDO", null, null, email, password, null, null);
		}
		return user.get();
	}

	public User updateUser(User user) {
		Optional<User> dbUser = userRepository.getUser(user.getId());
		if(dbUser.isPresent() && emailExist(user.getEmail()) == false) {
			if(user.getIdentification() != null) dbUser.get().setIdentification(user.getIdentification());
			if(user.getName() != null) dbUser.get().setName(user.getName());
			if(user.getAddress() != null) dbUser.get().setAddress(user.getAddress());;
			if(user.getCellPhone() != null) dbUser.get().setCellPhone(user.getCellPhone());
			if(user.getPassword() != null) dbUser.get().setPassword(user.getPassword());;
			if(user.getZone() != null) dbUser.get().setZone(user.getZone());
			if(user.getType() != null) dbUser.get().setType(user.getType());
			userRepository.update(user);
			return dbUser.get(); 
		} else {
			return user;
		}
	}

	public Integer deleteUser(Integer id) {
		Optional<User> dbUser = userRepository.getUser(id);
		if(dbUser.isPresent()) {
			userRepository.delete(dbUser.get());
			return 0;
		}else {
			return id;
			
		}
	}
}
