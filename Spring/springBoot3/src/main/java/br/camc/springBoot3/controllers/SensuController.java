package br.camc.springBoot3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.camc.springBoot3.models.Sensu;
import br.camc.springBoot3.repositories.SensuRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exericio Sensu")
@RestController
@RequestMapping("/sensu")
public class SensuController {
	
	@Autowired
	private SensuRepository sensuRepository;
	
	@ApiOperation(value= "Adiciona Sensu retorna se foi bem sucessedido", response = Iterable.class, tags = "sensu")
	@PostMapping
	public Sensu add(@RequestBody Sensu sensu){
		return sensuRepository.save(sensu);
	}
	
	
	@ApiOperation(value= "Retorna todos os Sensu", response = Iterable.class, tags = "sensu")
	@GetMapping
	public List<Sensu> getAll(){
		return sensuRepository.findAll();
	}
	
	@ApiOperation(value= "Altera o Sensu pelo id", response = Iterable.class, tags = "sensu")
	@PutMapping("/{id}")
	public Sensu updateById(@RequestBody Sensu sensu, @PathVariable Long id) {
		Optional<Sensu> s = sensuRepository.findById(id);
		if(s.isEmpty()) return null;
		s.get().setYear(sensu.getYear());
		s.get().setPopulation(sensu.getPopulation());
		return sensuRepository.save(s.get());
	}
	
	@ApiOperation(value= "Deleta o Sensu pelo id", response = Iterable.class, tags = "sensu")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		sensuRepository.deleteById(id);
	}
	
	@ApiOperation(value= "Retorna o Sensu pelo Ano", response = Iterable.class, tags = "sensu")
	@PostMapping("/")
	public List<Sensu> getByYear(@RequestParam int year) {
		return sensuRepository.getSensuByYear(year);
	}

}
