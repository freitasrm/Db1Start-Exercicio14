package br.com.db1.pedido;

import org.junit.Assert;
import org.junit.Test;

public class PedidoHistoricoTeste{

	@Test
	public void deveRetornarStatusEObrigatorio() {
		try {
			new PedidoHistorico(null);
		} catch (Exception e) {
			Assert.assertEquals("Campo status é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void deveCriarUmHistorico() {
		PedidoHistorico historico = new PedidoHistorico(PedidoStatus.ABERTO);
		Assert.assertEquals(PedidoStatus.ABERTO, historico.getStatus());
		Assert.assertNotNull(historico.getData());
	}
}