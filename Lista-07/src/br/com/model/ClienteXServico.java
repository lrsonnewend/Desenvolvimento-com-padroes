package br.com.model;

public class ClienteXServico {
	private int idCliente, idServico;
	
	private ClienteXServico() {

	}
	
	public static ClienteXServico newCS() {
		return new ClienteXServico();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	
	

}
