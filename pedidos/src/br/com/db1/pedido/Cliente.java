package br.com.db1.pedido;

public class Cliente {

	private String nome;
	private String cpf;
	private ClienteStatus status;
	
	public Cliente(String nome, String cpf) {
		if(nome == null) {
			throw new RuntimeException("Nome do cliente é obrigatório.");
		}
		if(cpf == null) {
			throw new RuntimeException("CPF do cliente é obrigatório.");
		}
		if(cpf.length() < 11) {
			throw new RuntimeException("CPF do cliente é inválido.");
		}
		this.nome = nome;
		this.cpf = cpf;
		this.status = ClienteStatus.ATIVO;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public ClienteStatus getStatus() {
		return this.status;
	}

	public void inativaCliente() {
		this.status = ClienteStatus.INATIVO;
	}
	
	public boolean isAtivo() {
		if(this.status == ClienteStatus.ATIVO) {
			return true;	
		}
		return false;
	}

	@Override
	public String toString() {
		return	"Cliente -"	+
				" Nome: "	+this.nome+
				" CPF: "	+this.cpf+
				" Status:"	+this.status;
	}

}
