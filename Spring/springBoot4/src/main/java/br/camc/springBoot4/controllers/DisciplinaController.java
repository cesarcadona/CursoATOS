package br.camc.springBoot4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.camc.springBoot4.models.Disciplina;
import br.camc.springBoot4.repositories.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exercicio Estudante")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	
	@ApiOperation(value= "Retorna todas as Disciplinas ", response = Iterable.class, tags = "disciplinas")
	@GetMapping
	public List<Disciplina> findAll(){
		return disciplinaRepository.findAll();
	}
	
	@ApiOperation(value= "Adiciona uma Disciplina ", response = Iterable.class, tags = "disciplinas")
	@PostMapping
	public Disciplina add(@RequestBody Disciplina disciplina){	
		if(!disciplinaRepository.existsByNome(disciplina.getNome()))
			return disciplinaRepository.save(disciplina);
		return new Disciplina();
	}
	

}
