package br.camc.ProjetoFinalFull.expceptions;

import java.text.MessageFormat;

public class GameNotFoundException extends RuntimeException{
	public GameNotFoundException(final Long id) {
		super(MessageFormat.format("Not found Game with {0}", id));
	}	
}
