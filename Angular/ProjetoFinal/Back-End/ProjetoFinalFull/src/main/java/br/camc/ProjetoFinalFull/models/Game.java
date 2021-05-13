package br.camc.ProjetoFinalFull.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.camc.ProjetoFinalFull.dtos.GameDto;
import br.camc.ProjetoFinalFull.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "GAME_TBL")
public class Game implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4257315622451726863L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false , updatable = false)
	private Long id;
	private String name;	
	private String gameGender;
	private String imageUrl;
	@Column(nullable = false , updatable = false)
	private String gameCode;
	
	@ManyToOne	
	private User user;
	
	
	public static Game from(GameDto gameDto) {
		Game game = new Game();
		game.setId(gameDto.getId());
		game.setName(gameDto.getName());
		game.setGameGender(gameDto.getGameGender());
		game.setUser(gameDto.getUser());
		return game;
	}
	
	

}
