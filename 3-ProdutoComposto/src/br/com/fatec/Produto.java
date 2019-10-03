package br.com.fatec;

public abstract class Produto {

	protected String nome;
	protected double valorProduto;
	protected String descricao;

	public String getNome() {
		return nome;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public String getDescricao() {
		return descricao;
	}
}