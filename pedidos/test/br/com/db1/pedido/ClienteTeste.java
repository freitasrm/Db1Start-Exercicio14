package br.com.db1.pedido;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ClienteTeste {
	
	@Test
	public void deveRetornarNomeEObrigatorio() {
		try {
			new Cliente(null, "123");
		} catch (Exception e) {
			Assert.assertEquals("Nome do cliente é obrigatório.", e.getMessage());
		}
	}
	
	
	@Test
	public void deveRetornarCpfEObrigatorio() {
		try {
			new Cliente("Rodrigo", null);
		} catch (Exception e) {
			Assert.assertEquals("CPF do cliente é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void deveRetornarCpfEInvalido() {
		try {
			new Cliente("Rodrigo Martins", "389");
		} catch (Exception e) {
			Assert.assertEquals("CPF do cliente é inválido.", e.getMessage());
		}
	}
	
	@Test
	public void deveCriarUmCliente() {
		Cliente cliente = new Cliente("Rodrigo Martins", "38909498862");
		
		Assert.assertEquals("Rodrigo Martins", cliente.getNome());
		Assert.assertEquals("38909498862", cliente.getCpf());
		Assert.assertEquals(ClienteStatus.ATIVO, cliente.getStatus());
	}
	
	@Test
	public void deveRetornarClienteAtivo() {
		Cliente cliente = new Cliente("Rodrigo Martins", "38909498862");
		Assert.assertTrue(cliente.isAtivo());
	}
}
