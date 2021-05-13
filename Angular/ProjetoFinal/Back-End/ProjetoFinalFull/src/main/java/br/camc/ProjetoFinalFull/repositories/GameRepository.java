package br.camc.ProjetoFinalFull.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.camc.ProjetoFinalFull.models.Game;
import br.camc.ProjetoFinalFull.models.User;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	public List<Game> findAllByUser(User user);

}
