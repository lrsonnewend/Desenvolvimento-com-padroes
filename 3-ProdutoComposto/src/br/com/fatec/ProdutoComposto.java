package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto {
	private List<Produto> produtos = new ArrayList<>();
	
	public ProdutoComposto(String nome, String descricao, List<Produto> produtos) {
		this.nome = nome;
		this.descricao = descricao;
		this.produtos.addAll(produtos);
		calcularValorTotal();
	}

	private void calcularValorTotal() {
		double valorTotal = valorProduto;
		for (Produto p : produtos) {
			valorTotal = valorTotal + p.getValorProduto();
		}		
		valorProduto = valorTotal;
	}

}