package br.camc.projetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.camc.projetoFinal.models.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
	

}
