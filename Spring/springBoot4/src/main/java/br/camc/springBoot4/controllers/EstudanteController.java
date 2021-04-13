package br.camc.springBoot4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.camc.springBoot4.models.Estudante;
import br.camc.springBoot4.repositories.EstudanteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exercicio Estudante")
@RestController
@RequestMapping("/estudante")
public class EstudanteController {

	@Autowired
	EstudanteRepository estudanteRepository;
	
	@ApiOperation(value= "Retorna todos os Estudantes ", response = Iterable.class, tags = "estudante")
	@GetMapping
	public List<Estudante> findAll(){
		return estudanteRepository.findAll();
	}
	
	@ApiOperation(value= "Adiciona Estudante retorna se foi bem sucessedido", response = Iterable.class, tags = "estudante")
	@PostMapping
	public Estudante add(@RequestBody Estudante estudante){
		return estudanteRepository.save(estudante);
	}
	
	@ApiOperation(value= "Retorna Estudante se achar pelo nome e id", response = Iterable.class, tags="estudante")
	@PostMapping("{id}{nome}")
	public String findEstudante(@RequestParam Long id, @RequestParam String nome) {
		try {
			return estudanteRepository.findByIdAndNome(id, nome).toString();
		} catch (Exception ex) {
			return ex+" Erro: Estudante não encontrado!"; 
		}
	}
	
	@ApiOperation(value= "Atualiza Estudante ", response = Iterable.class, tags="estudante")
	@PutMapping
	public String att(@RequestBody Estudante estudante, @RequestParam Long id, @RequestParam String nome) {
		try {
			Estudante e = estudanteRepository.findByIdAndNome(id, nome);
			e.setNome(estudante.getNome());
			e.setDataNasc(estudante.getDataNasc());
			e.setEmail(estudante.getEmail());
			e.setMatricula(estudante.getMatricula());
			e.setNacionalidade(estudante.getNacionalidade());			
			estudanteRepository.save(e);
			return e.toString();
		} catch (Exception ex) {
			return ex+" Erro: Estudante não encontrado!"; 
		}
		
	}
	@ApiOperation(value= "Deleta Estudante ", response = Iterable.class, tags="estudante")
	@DeleteMapping
	public String delete(@RequestParam Long id, @RequestParam String nome) {
		try {
			Estudante e = estudanteRepository.findByIdAndNome(id, nome);
			estudanteRepository.delete(e);
			return e.toString() + " foi deletado!";
		} catch (Exception e) {
			return e+" Erro: Estudante não encontrado!";
		}
		
	}
}
