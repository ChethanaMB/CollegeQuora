package com.project.collegequora.repository;

import com.project.collegequora.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

    User findByEmail(String Email);
}
