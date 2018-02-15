package br.com.caelum.mentoria.models;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RoleTest {
	
	@Test
	public void deveAutorizarUmUsuarioAdicionado() {
		Role papel = new Role();
		User usuario = Mockito.mock(User.class);
		Mockito.when(usuario.getUsername()).thenReturn("usuario");
		User usuarioNaoAutorizado = Mockito.mock(User.class);
		Mockito.when(usuarioNaoAutorizado.getUsername()).thenReturn("nao autorizado");
		
		papel.add(usuario);
		
		Assert.assertTrue(papel.authorize(usuario));
		Assert.assertFalse(papel.authorize(usuarioNaoAutorizado));
		
	}

}
