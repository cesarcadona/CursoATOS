package br.camc.ProjetoFinalFull.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.camc.ProjetoFinalFull.dtos.GameDto;
import br.camc.ProjetoFinalFull.dtos.UserDto;
import br.camc.ProjetoFinalFull.models.Game;
import br.camc.ProjetoFinalFull.services.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService service;
	
	
	@PostMapping("/get/all")
	public ResponseEntity<List<GameDto>> getAllByUserId(@RequestBody UserDto user){		
		List<Game> games = service.findAllById(user.getId());
		List<GameDto> gamesDto = games.stream().map(GameDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(gamesDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<GameDto> getById(@PathVariable Long id){
		Game game = service.findGameByID(id);
		return new ResponseEntity<>(GameDto.from(game), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<GameDto> addGame(@RequestBody GameDto game){		
		Game newGame = service.addGame(Game.from(game));			
		return new ResponseEntity<>(GameDto.from(newGame), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<GameDto> updateGame(@RequestBody Game game){
		Game updateGame = service.updateGame(game);
		return new ResponseEntity<>(GameDto.from(updateGame), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		service.deleteGame(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
