package br.camc.springBoot4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.camc.springBoot4.models.Disciplina;
import br.camc.springBoot4.models.Estudante;
import br.camc.springBoot4.models.Matricula;
import br.camc.springBoot4.repositories.DisciplinaRepository;
import br.camc.springBoot4.repositories.EstudanteRepository;
import br.camc.springBoot4.repositories.MatriculaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs exercicio Estudante")
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Autowired
	EstudanteRepository estudanteRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	@ApiOperation(value = "Retorna todas as Matriculas ", response = Iterable.class, tags = "matriculas")
	@GetMapping
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@ApiOperation(value = "Adiciona Matricula ", response = Iterable.class, tags = "matriculas")
	@PostMapping
	public String add(@RequestParam String nomeDisciplina, @RequestParam String nomeEstudante,	@RequestParam Long idEstudante) {
		try {

			Disciplina disciplina = disciplinaRepository.findByNome(nomeDisciplina);
			if (disciplina == null)
				return "Esta disciplina não existe";

			Estudante estudante = estudanteRepository.findByIdAndNome(idEstudante, nomeEstudante);
			if (estudante == null)
				return "Este estudante não existe";

			Matricula matricula = new Matricula(true, estudante, disciplina);

			long numeroDeVagasDisponivel = matricula.getDisciplina().getNumeroVagas()
					- matriculaRepository.countByDisciplina(disciplina);

			if (numeroDeVagasDisponivel == 0)
				return "Não foi possivel realizar a matricula, número de vagas indisponivel";

			if (matriculaRepository.countByEstudanteAndDisciplina(matricula.getEstudante(),
					matricula.getDisciplina()) != 0)
				return "Não foi possivel realizar a matricula o estudante já esta matriculado nessa disciplina ";

			Matricula m = matriculaRepository.save(matricula);
			return m.toString();

		} catch (Exception e) {
			return e + " Erro: Não foi possivel realizar a matricula";
		}

	}

	@ApiOperation(value = "Cancela Matricula ", response = Iterable.class, tags = "matriculas")
	@PutMapping
	public String cancel(@RequestParam String nomeDisciplina, @RequestParam String nomeEstudante, @RequestParam Long idEstudante) {
		
		Estudante e = estudanteRepository.findByIdAndNome(idEstudante, nomeEstudante);
		Disciplina d = disciplinaRepository.findByNome(nomeDisciplina);
				
		Matricula m = matriculaRepository.findByEstudanteAndDisciplina(e, d);
		if (m == null)
			return "Não foi possivel achar esta matricula";
		m.setStatus(false);
		matriculaRepository.save(m);
		return "Matricula Cancelada: " + m.toString();
	}

}
