package br.com.caelum.mentoria.models;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Set<String> authorizedUsernames = new HashSet<String>();

	public void add(User user) {
		this.authorizedUsernames.add(user.getUsername());
	}

	public boolean authorize(User usuario) {
		return this.authorizedUsernames.contains(usuario.getUsername());
	}

}
