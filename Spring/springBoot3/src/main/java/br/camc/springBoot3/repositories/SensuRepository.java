package br.camc.springBoot3.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.camc.springBoot3.models.Sensu;

public interface SensuRepository extends JpaRepository<Sensu, Long>{
	
	public List<Sensu> getSensuByYear(int year);
}
