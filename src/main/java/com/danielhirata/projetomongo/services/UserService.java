package com.danielhirata.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielhirata.projetomongo.domain.User;
import com.danielhirata.projetomongo.dto.UserDTO;
import com.danielhirata.projetomongo.repository.UserRepository;
import com.danielhirata.projetomongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));

	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(null, objDTO.getName(), objDTO.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newUser = repository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
		updateData(newUser, obj);
		return repository.save(newUser);
	}
	
	public void updateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}
}
