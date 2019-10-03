package br.com.fatec;

public class ProdutoUnitario extends Produto {

	public ProdutoUnitario(String nome, double valorProduto, 
			Desconto deconto, String descricao) {
		this.nome = nome;
		this.valorProduto = valorProduto;
		this.descricao = descricao;
	}
	
}