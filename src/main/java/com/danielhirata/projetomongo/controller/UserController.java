package com.danielhirata.projetomongo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielhirata.projetomongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User daniel = new User("1", "Daniel", "daniel@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(daniel, alex));
		return ResponseEntity.ok().body(lista);
	}
}
