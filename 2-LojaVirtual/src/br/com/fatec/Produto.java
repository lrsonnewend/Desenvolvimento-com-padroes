package br.com.fatec;

public class Produto {
	private String nome;
	private double valorProd;

	public Produto(String nome, double valorProd) {
		super();
		this.nome = nome;
		this.valorProd = valorProd;
	}

	public String getNome() {
		return nome;
	}

	public double getValorProd() {
		return valorProd;
	}

}
