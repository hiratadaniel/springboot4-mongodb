package com.danielhirata.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danielhirata.projetomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
