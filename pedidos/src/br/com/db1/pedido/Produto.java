package br.com.db1.pedido;

public class Produto {
	
	private String codigo;
	private String nome;
	private Double valor;
	private ProdutoStatus status;
	
	public Produto(String codigo, String nome, Double valor) {
		if(codigo == null) {
			throw new RuntimeException("Campo código do produto é obrigatório.");
		}
		if(nome == null) {
			throw new RuntimeException("Campo nome do produto é obrigatório.");
		}
		if(valor == null) {
			throw new RuntimeException("Campo valor do produto é obrigatório.");
		}
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.status = ProdutoStatus.ATIVO;
	}
	
	public ProdutoStatus getStatus() {
		return status;
	}
	
	public Double getValor() {
		return this.valor;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void inativaProduto() {
		if(this.getStatus() != ProdutoStatus.INATIVO) {
			this.status = ProdutoStatus.INATIVO;
		}
	}

	public void ativaProduto() {
		if(this.getStatus() != ProdutoStatus.ATIVO) {
			this.status = ProdutoStatus.ATIVO;
		}
	}
	
	public boolean isAtivo() {
		if(this.status.equals(ProdutoStatus.ATIVO)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Codigo: "+this.codigo+" Nome: "+this.nome+" Valor: "+ String.format("%.2f",this.getValor());
	}

}
