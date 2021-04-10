package br.camc.springBoot3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.camc.springBoot3.models.Candidato;
import br.camc.springBoot3.repositories.CandidatoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exericio Urna Eletrônica")
@RestController
@RequestMapping("/urna")
public class UrnaController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@ApiOperation(value= "Adiciona candidato retorna se foi bem sucessedido", response = Iterable.class, tags = "urna")
	@PostMapping
	public Candidato addCandidate(@RequestBody Candidato candidato){
		return candidatoRepository.save(candidato);
	}
	
	@ApiOperation(value= "Retorna todos os candidatos", response = Iterable.class, tags = "urna")
	@GetMapping
	public List<Candidato> getAll(){
		return candidatoRepository.findAll();
	}

	@ApiOperation(value= "Retorna candidato pelo numero de eleição", response = Iterable.class, tags = "urna")	
	@PostMapping("/")
	public Candidato getCandidateByElectionNumber(@RequestParam int electionNumber) {
		return candidatoRepository.findByElectionNumber(electionNumber);
				
	}
	
	@ApiOperation(value= "Retorna candidato pelo id", response = Iterable.class, tags = "urna")
	@PostMapping("/{id}")
	public Optional<Candidato> getCandidateById(@PathVariable Long id) {
		return candidatoRepository.findById(id);
				
	}
		
	
	@ApiOperation(value= "Atualiza candidato retorna o candidato", response = Iterable.class, tags = "urna")
	@PutMapping("/{id}")
	public Candidato updateCandidateById(@RequestBody Candidato candidato, @PathVariable Long id){
		
		Optional<Candidato> candidatos = candidatoRepository.findById(id);
		if(candidatos.isEmpty()) return null;
		candidatos.get().setElectionNumber(candidato.getElectionNumber());
		candidatos.get().setName(candidato.getName());
		candidatos.get().setVotes(candidato.getVotes());
		return candidatoRepository.save(candidatos.get());
	}
	
	
	
	
	
	

	
	
}
