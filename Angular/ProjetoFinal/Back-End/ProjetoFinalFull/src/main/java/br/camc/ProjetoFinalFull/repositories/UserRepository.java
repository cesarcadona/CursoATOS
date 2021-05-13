package br.camc.ProjetoFinalFull.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.camc.ProjetoFinalFull.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByUsername(String username);

}
