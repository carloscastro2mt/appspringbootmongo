package com.app.webmongo.repository.crud;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.webmongo.model.User;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);

}
