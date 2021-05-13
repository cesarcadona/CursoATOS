package br.camc.ProjetoFinalFull.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.camc.ProjetoFinalFull.dtos.UserDto;
import br.camc.ProjetoFinalFull.enums.ERole;
import br.camc.ProjetoFinalFull.models.AuthRequest;
import br.camc.ProjetoFinalFull.models.User;
import br.camc.ProjetoFinalFull.services.UserService;
import br.camc.ProjetoFinalFull.utils.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> doRegister(@RequestBody UserDto userDto){
		userService.addUser(User.from(userDto));
		return new ResponseEntity<>(true,HttpStatus.CREATED);
	}
	
	@PostMapping("/authenticate")
	public String doLogin(@RequestBody AuthRequest request) throws Exception{		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		} catch (Exception e) {
			throw new Exception("Ïnvalid username/password");
		}
			
		
		return jwtUtil.generateToken(request.getUsername());
	}
	
	@PostMapping("/getUser")
	public ResponseEntity<UserDto> getUserLogged(@RequestBody AuthRequest request) {
		User userLogged = new User();
		userLogged.setUsername(request.getUsername());		
		userLogged = userService.findByUsername(userLogged);
		
		return new ResponseEntity<>(UserDto.from(userLogged), HttpStatus.OK);
	}

}
