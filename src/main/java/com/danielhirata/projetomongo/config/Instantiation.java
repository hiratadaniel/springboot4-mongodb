package com.danielhirata.projetomongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielhirata.projetomongo.domain.User;
import com.danielhirata.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Paula", "mariapaula@gmail.com");
		User alex = new User(null, "Alex Guto", "alex@gmail.com");
		User ana = new User(null, "Ana Clara", "ana@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, ana));
		
	}

}
