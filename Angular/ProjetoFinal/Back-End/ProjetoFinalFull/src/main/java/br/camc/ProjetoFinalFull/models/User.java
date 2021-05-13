package br.camc.ProjetoFinalFull.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.camc.ProjetoFinalFull.dtos.UserDto;
import br.camc.ProjetoFinalFull.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "USER_TBL")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4949172573767914718L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private ERole role;
	
	public static User from(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());		
		return user;
	}
	
	

}
