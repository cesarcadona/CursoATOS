package br.camc.ProjetoFinalFull.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.camc.ProjetoFinalFull.expceptions.GameNotFoundException;
import br.camc.ProjetoFinalFull.models.Game;
import br.camc.ProjetoFinalFull.models.User;
import br.camc.ProjetoFinalFull.repositories.GameRepository;

@Service
@Transactional
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Autowired
	private UserService userService;
	
	public Game addGame(Game game) {		
		game.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Video-Game-Controller-Icon-IDV-green.svg/768px-Video-Game-Controller-Icon-IDV-green.svg.png");
		game.setGameCode(UUID.randomUUID().toString());
		return repository.save(game);
	}
	
	public List<Game> findAllById(Long id){
		User user = userService.findById(id);
		return repository.findAllByUser(user);
	}
	
	public List<Game> findAllGames(){
		
		return repository.findAll();
		
	}
	
	public Game updateGame(Game game) {
		findGameByID(game.getId());
		return repository.save(game);
	}
	
	public Game findGameByID(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new GameNotFoundException(id));
	}
	
	public void deleteGame(Long id) {
		Game game = findGameByID(id);
		repository.delete(game);
	}
	
	
	

}
