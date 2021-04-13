package br.camc.springBoot4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.camc.springBoot4.models.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
	
	public Estudante findByIdAndNome(Long id, String nome);
	
	
}
