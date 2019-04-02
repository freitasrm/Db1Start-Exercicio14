package br.com.db1.pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PedidoHistorico {

	private PedidoStatus status;
	private LocalDateTime data;
	
	public PedidoHistorico(PedidoStatus status) {
		if(status == null) {
			throw new RuntimeException("Campo status é obrigatório.");
		}
		this.status = status;
		this.data = LocalDateTime.now();
	}
	
	public LocalDateTime getData() {
		return this.data;
	}

	public PedidoStatus getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm");
		
		return "Status: "	+this.status+
				" Data: "	+this.data.format(dataFormat)+
				" Hora: "	+this.data.format(horaFormat);
	}

		
	
}
