package br.camc.springBoot3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.camc.springBoot3.models.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	
	public Candidato findByElectionNumber(int electionNumber);
	
	
}
