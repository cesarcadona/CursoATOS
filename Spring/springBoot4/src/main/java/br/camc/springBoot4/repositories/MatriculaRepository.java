package br.camc.springBoot4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.camc.springBoot4.models.Disciplina;
import br.camc.springBoot4.models.Estudante;
import br.camc.springBoot4.models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	
	@Query("select count(m) from Matricula m where m.disciplina=:disciplina AND m.status='true'")
	public int countByDisciplina(@Param("disciplina") Disciplina disciplina);
	
	@Query("select m from Matricula m where m.estudante=:estudante AND m.disciplina=:disciplina")
	public Matricula findByEstudanteAndDisciplina(@Param("estudante") Estudante estudante,@Param("disciplina") Disciplina disciplina);
	
	@Query("select count(m) from Matricula m where m.estudante=:estudante AND m.disciplina=:disciplina")
	public int countByEstudanteAndDisciplina(@Param("estudante") Estudante estudante,@Param("disciplina") Disciplina disciplina);
	
}
