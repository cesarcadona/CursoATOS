package br.camc.ProjetoFinalFull.expceptions;

import java.text.MessageFormat;

public class UserAlreadyExistisException extends RuntimeException {
	public UserAlreadyExistisException(final Long id) {
		super(MessageFormat.format("User already found with {0}", id));
	}
	public UserAlreadyExistisException(final String username) {
		super(MessageFormat.format("User already found with this username {0}", username));
	}
}
