package br.camc.ProjetoFinalFull.expceptions;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(final Long id) {
		super(MessageFormat.format("Not found User with {0}", id));
	}

}
