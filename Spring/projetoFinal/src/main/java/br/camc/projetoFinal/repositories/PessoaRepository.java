package br.camc.projetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.camc.projetoFinal.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	
}
