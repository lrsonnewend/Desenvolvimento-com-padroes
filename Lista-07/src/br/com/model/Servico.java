package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Servico {
	
	private int id_servico;
	private String nome_servico;
	private double valor_servico;
	

	private Servico() {
		
	}
	
	public static Servico newServico() {
		return new Servico();
	}

	public int getId_servico() {
		return id_servico;
	}

	public void setId_servico(int id_servico) {
		this.id_servico = id_servico;
	}

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}

	public double getValor_servico() {
		return valor_servico;
	}

	public void setValor_servico(double valor_servico) {
		this.valor_servico = valor_servico;
	}
	
	
	
	

}
