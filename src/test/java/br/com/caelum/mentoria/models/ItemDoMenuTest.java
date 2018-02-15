package br.com.caelum.mentoria.models;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ItemDoMenuTest {
	
	private final String titulo = "Titulo";
	
	@Test
	public void deveTerUmTitulo() {
		MenuItem item = new MenuItem(titulo);
		assertEquals(titulo, item.getTitle());
	}
	
	@Test
	public void podeTerUmaDescricao() {
		String descricao = "Descrição";
		MenuItem itemComDescricao = new MenuItem(titulo,descricao);
		assertEquals(Optional.of(descricao),itemComDescricao.getDescription());
		
	}

	@Test
	public void podeNaoTerUmaDescricao() {
		MenuItem itemSemDescricao = new MenuItem(titulo);
		assertEquals(Optional.empty(),itemSemDescricao.getDescription());
	}
	
	@Test
	public void deveAdicionarERetornarUmaListaDeFilhosEmOrdem() {
		MenuItem itemPai = new MenuItem("item pai");
		MenuItem itemFilho1 = new MenuItem("item filho 1");
		MenuItem itemFilho2 = new MenuItem("item filho 2");
		
		itemPai.addChild(itemFilho1);
		itemPai.addChild(itemFilho2);

		assertThat(itemPai.getChildren(), contains(itemFilho1,itemFilho2));
	}
	
	@Test
	public void deveAdicionarPapeisEDecidirAVisibilidadeDeUmUsuarioAPartirDeles() {
		MenuItem item = new MenuItem(titulo);
		Role papel = mock(Role.class);
		User usuarioAutorizado = mock(User.class);
		User usuarioNaoAutorizado = mock(User.class);
		Mockito.when(papel.authorize(usuarioAutorizado)).thenReturn(true);
		Mockito.when(papel.authorize(usuarioNaoAutorizado)).thenReturn(false);
		
		item.addRole(papel);
		
		Assert.assertTrue(item.visibleFor(usuarioAutorizado));
		Assert.assertFalse(item.visibleFor(usuarioNaoAutorizado));
		
	}
	
	
}
