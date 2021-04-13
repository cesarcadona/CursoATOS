package br.camc.springBoot4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.camc.springBoot4.models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	public Disciplina findByNome(String nome);
	
	public boolean existsByNome(String nome);

}
