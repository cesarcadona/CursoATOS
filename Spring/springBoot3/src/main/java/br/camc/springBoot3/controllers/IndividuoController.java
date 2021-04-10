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

import br.camc.springBoot3.models.Individuo;
import br.camc.springBoot3.repositories.IndividuoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exericio Individuos")
@RestController
@RequestMapping("/individuo")
public class IndividuoController {
	
	@Autowired
	IndividuoRepository individuoRepository;
	
	@ApiOperation(value= "Adiciona Sensu retorna se foi bem sucessedido", response = Iterable.class, tags = "individuo")
	@PostMapping
	public Individuo add(@RequestBody Individuo individuo){
		return individuoRepository.save(individuo);
	}
	@ApiOperation(value= "Retorna todos os Individuos", response = Iterable.class, tags = "individuo")
	@GetMapping
	public List<Individuo> getAll(){
		return individuoRepository.findAll();
	}
	
	@ApiOperation(value= "Retorna pelo tipo", response = Iterable.class, tags = "individuo")
	@PostMapping("/")
	public List<Individuo> findByType(@RequestParam String type){
		return individuoRepository.findByType(type);
	}
	
	@ApiOperation(value= "Altera o Individuo pelo id", response = Iterable.class, tags = "individuo")
	@PutMapping("/{id}")
	public Individuo updateById(@RequestBody Individuo individuo, @PathVariable Long id) {
		Optional<Individuo> indi = individuoRepository.findById(id);
		if(indi.isEmpty()) return null;
		indi.get().setName(individuo.getName());
		indi.get().setType(individuo.getType());
		return individuoRepository.save(indi.get());
	}
	
	
	

}
