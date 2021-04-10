package br.camc.springBoot3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.camc.springBoot3.models.Individuo;

public interface IndividuoRepository extends JpaRepository<Individuo, Long>{

	public List<Individuo> findByType(String type);
}
