package br.com.db1.pedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	static final int MAXIMO_ITENS = 10;
	private String numero;
	private Cliente cliente;
	private PedidoStatus status;
	private List<PedidoItem> itens= new ArrayList<>();
	private List<PedidoHistorico> historicos = new ArrayList<>();
		
	public Pedido(Cliente cliente, String numeroPedido) {
		if (cliente == null) {
			throw new RuntimeException("Cliente é obrigatório existir!");
		}
		if (!cliente.isAtivo()) {
			throw new RuntimeException("Cliente é obrigatório ser ativo!");
		}
		if (numeroPedido == null) {
			throw new RuntimeException("Número é obrigatório existir!");
		}
		this.numero = numeroPedido;
		this.cliente = cliente;
		this.status = PedidoStatus.ABERTO;
		this.historicos.add(new PedidoHistorico(this.status));
	}
			
	public void addItens(Produto p, Double q) {
		if(this.getItem().size() < MAXIMO_ITENS) {
			this.itens.add(new PedidoItem(p,q));	
		}
	}
	
	public List<PedidoHistorico> getHistorico() {
		return List.copyOf(this.historicos);
	}

	public List<PedidoHistorico> getHistorico(PedidoStatus p){
		List<PedidoHistorico> ph = new ArrayList<PedidoHistorico>();
		for(int i = 0;i < getHistorico().size();i++) {
			 if(getHistorico().get(i).getStatus()==p) {
				 ph.add(this.historicos.get(i));
			 }
		}
		return ph;
	}

	public List<PedidoItem> getItem() {
		return List.copyOf(this.itens);
	}

	public String getNumero() {
		return this.numero;
	}
	
	public PedidoStatus getStatus() {
		return this.status;
	}

	private boolean pedidoAberto() {
		if(this.status.equals(PedidoStatus.ABERTO)) {
			return true;
		}
		return false;
	}

	public void cancelaPedido() {
		if (!this.pedidoAberto()) {
			throw new RuntimeException("Pedido precisa estar ABERTO para ser Cancelado!");
		}
		this.status = PedidoStatus.CANCELADO;
		this.historicos.add(new PedidoHistorico(this.status));
	}
	
	
	public void reabrePedido() {
		if(!(this.pedidoAberto())) {
			this.status = PedidoStatus.ABERTO;
			this.historicos.add(new PedidoHistorico(this.status));
		}
	}
	
	public void faturaPedido() {
		if (!(this.pedidoAberto())) {
			throw new RuntimeException("Pedido precisa estar ABERTO para ser Faturado!");
		}
		if (!this.cliente.isAtivo()) {
			throw new RuntimeException("Cliente precisa estar ATIVO para faturar Pedido!");
		}
		if (this.getItem().size() == 0) {
			throw new RuntimeException("Pedido precisa ter no mínimo 1 item para ser Faturado!");
		}
		this.status = PedidoStatus.FATURADO;
		this.historicos.add(new PedidoHistorico(this.status));
	}

	public String somaQuantidadeItens() {
		int i = 0;
		Double resultado = 0.0;
		while( i < this.getItem().size()) {
			resultado += this.getItem().get(i).getQuantidadeItem();
			i++;
		}
		return String.format("%.2f",resultado);
	}
	
	public String somaValorItens() {
		int i = 0;
		Double resultado = 0.0;
		while( i < this.getItem().size()) {
			resultado += this.getItem().get(i).getValorItem();
			i++;
		}
		return String.format("%.2f",resultado);
	}
	
	@Override
	public String toString() {
		return 	"Pedido - "
				+" Status: "		+this.status
				+" Numero: "		+this.numero
				+"\n"				+this.cliente
				+"\n"				+this.itens;
	}
	
}
