package br.com.db1.pedido;

public class PedidoItem {
	
	private Produto produto;
	private Double quantidade;
	private Double valor;
	
	public PedidoItem(Produto produto, Double quantidade) {
		if(produto == null) {
			throw new RuntimeException("Campo produto é obrigatório.");
		}
		if(!produto.isAtivo()) {
			throw new RuntimeException("Produto precisa estar ATIVO para ser Adicionado!");
		}
		if(quantidade == null) {
			throw new RuntimeException("Campo quantidade é obrigatório.");
		}
		if(quantidade <= 0) {
			throw new RuntimeException("Campo quantidade deve ser maior que zero.");
		}
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = quantidade * produto.getValor();
	}
	
	public Double getQuantidadeItem() {
		return this.quantidade;
	}
	
	public Double getValorItem() {
		return this.valor;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
		
	@Override
	public String toString() {
		return "\nProduto - "+this.produto+" Quantidade: "+String.format("%.2f",this.quantidade)+" Valor: "+String.format("%.2f",this.valor);
	}

	
}
