package br.camc.ProjetoFinalFull.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.camc.ProjetoFinalFull.enums.ERole;
import br.camc.ProjetoFinalFull.expceptions.UserAlreadyExistisException;
import br.camc.ProjetoFinalFull.expceptions.UserNotFoundException;
import br.camc.ProjetoFinalFull.models.User;
import br.camc.ProjetoFinalFull.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AppEncoder encoder;
	
	public User addUser(User user) {
		if(repository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserAlreadyExistisException(user.getUsername());
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(ERole.USER);
		return repository.save(user);
	}
	
	public User findByUsername(User user) {		
		User findUser = repository.findByUsername(user.getUsername()).orElseThrow(
				() -> new UserAlreadyExistisException(user.getId()));
		return findUser;
	}
	
	public User findById(Long id) {
		User findUser = repository.findById(id).orElseThrow(
				() -> new UserNotFoundException(id));
		return findUser;
	}
	
	

}
