package br.camc.ProjetoFinalFull.dtos;

import br.camc.ProjetoFinalFull.enums.ERole;
import br.camc.ProjetoFinalFull.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String username;
	private String password;
	private ERole role;

	
	public static UserDto from(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		return userDto;
	}
}
