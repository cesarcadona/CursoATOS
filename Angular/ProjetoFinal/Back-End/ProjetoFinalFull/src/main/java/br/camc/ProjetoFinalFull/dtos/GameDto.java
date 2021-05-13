package br.camc.ProjetoFinalFull.dtos;

import br.camc.ProjetoFinalFull.models.Game;
import br.camc.ProjetoFinalFull.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@NoArgsConstructor
public class GameDto {
	private Long id;
	private String name;
	private String gameGender;
	private String imageUrl;
	private User user;
	
	public static GameDto from(Game game) {
		GameDto gameDto = new GameDto();
		gameDto.setId(game.getId());
		gameDto.setName(game.getName());
		gameDto.setGameGender(game.getGameGender());
		gameDto.setImageUrl(game.getImageUrl());
		if(Objects.nonNull(game.getUser())) {
			gameDto.setUser(game.getUser());
		}
		return gameDto;
	}
	

}
