package br.com.db1.pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class PedidoTeste {
	
	List<Produto> produto =  new ArrayList<>();
	Cliente cliente;
	Pedido pedido;
	
	@Before
	public void init() {
		// Criando produtos;
		produto.add(new Produto("01","Caneta",2.50));
		produto.add(new Produto("02","Lapis",0.50));
		produto.add(new Produto("03","Copo Plastico",0.05));
		produto.add(new Produto("04","Borracha",0.30));
		produto.add(new Produto("05","Corretivo",3.00));
		produto.add(new Produto("06","Caderno",10.00));
		produto.get(5).inativaProduto();
		
		// Criando cliente
		cliente = new Cliente("Rodrigo", "38909498862");
		
		// Criando pedido
		pedido = new Pedido(cliente,"01");
		
		//Adicionando item ao pedido
		pedido.addItens(produto.get(0),5.0);
		pedido.addItens(produto.get(1),10.0);
		pedido.addItens(produto.get(2),7.5);
		pedido.addItens(produto.get(3),3.0);
		pedido.addItens(produto.get(4),4.0);
		//pedido.addItens(produto.get(5),4.0); // não deve inserir inativo
		pedido.addItens(produto.get(0),8.0);
		pedido.addItens(produto.get(1),2.5);
		pedido.addItens(produto.get(2),6.0);
		pedido.addItens(produto.get(3),9.0);
		pedido.addItens(produto.get(4),22.0);
		//pedido.addItens(produto.get(5),22.0); // não deve inserir inativo
		pedido.addItens(produto.get(0),33.0); //não deve inserir passou da cota
		
		//Alterando status do pedido
		pedido.cancelaPedido();
		pedido.reabrePedido();
		pedido.cancelaPedido(); 
		pedido.reabrePedido();
		pedido.faturaPedido();
		pedido.reabrePedido();
		pedido.faturaPedido();
		
	}
/*	
	@Test
	public void deveTestarClasse() {
		// dados pedido
		//System.out.println(pedido);
		
		// cancela pedido
		System.out.println();
		
		// dados pedido - cancelado
		//System.out.println(pedido);
		System.out.println();
				
		System.out.println(pedido.getHistorico(PedidoStatus.ABERTO));
		System.out.println(pedido.getHistorico(PedidoStatus.CANCELADO));
		System.out.println(pedido.getHistorico(PedidoStatus.FATURADO));
		
		System.out.println();
		
		//System.out.println(pedido);
	}
*/	
	@Test
	public void deveTestarRelatorio1(){
        /*
			- Número pedido
	        - Data pedido	
	        - Status
	        - Data faturamento ou cancelamento
	        - Total de itens do pedido
	        - Valor total do pedido
        */
		// Numero Pedido
		System.out.print("Número Pedido: "+pedido.getNumero());
		// Data pedido
		LocalDateTime dataPedido = pedido.getHistorico(PedidoStatus.ABERTO).get(0).getData();
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print(" Data: "+dataPedido.format(dataFormat));
		// Status
		System.out.println(" Status do Pedido: "+pedido.getStatus());
		// Data Faturamento/Cancelamento
		System.out.println("Histórico de Alterações: ");
		System.out.println(pedido.getHistorico(PedidoStatus.CANCELADO));
		System.out.println(pedido.getHistorico(PedidoStatus.FATURADO));
		// Total Itens
		System.out.println("Total de Itens do Pedido: "+pedido.somaQuantidadeItens());
		System.out.println("Valor Total do Pedido: "+pedido.somaValorItens());
	}

	@Test
	public void deveTestarRelatorio2(){
        /*
			- Número pedido
	        - Data pedido	
	        - Status
	        - Data faturamento ou cancelamento
	        - Total de itens do pedido
	        - Valor total do pedido
        */
		System.out.println();
		// Numero Pedido
		System.out.print("Número Pedido: "+pedido.getNumero());
		// Data pedido
		LocalDateTime dataPedido = pedido.getHistorico(PedidoStatus.ABERTO).get(0).getData();
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print(" Data: "+dataPedido.format(dataFormat));
		// Status
		System.out.println(" Status do Pedido: "+pedido.getStatus());
		// Data Faturamento/Cancelamento
		System.out.println("Histórico de Alterações: ");
		System.out.println(pedido.getHistorico(PedidoStatus.CANCELADO));
		System.out.println(pedido.getHistorico(PedidoStatus.FATURADO));
		// Total Itens
		System.out.println("Total de Itens do Pedido: "+pedido.somaQuantidadeItens());
		System.out.println("Valor Total do Pedido: "+pedido.somaValorItens());
		
		//Itens do Pedido
		System.out.println(pedido.getItem());
		
	}
}