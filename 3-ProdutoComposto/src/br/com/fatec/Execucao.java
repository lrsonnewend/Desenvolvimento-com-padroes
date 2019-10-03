package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Execucao {
	public static void main(String[] args) {
	
		Desconto desconto = new Desconto(101);
		Produto p1 = new ProdutoUnitario("NoteBook Dell", 2500, desconto, "Notebook Dell\nHD 500GB, RAM 8GB\n" + 
				"\nProcessador Intel Core i5 7th Gen.\n");
		
		Produto p2 = new ProdutoUnitario("MouseWireless Positivo", 230, desconto, "Mouse Wireless Positivo "
				+ "\nresolucao 140 DPI\n garantia de 1 ano do fabricante.");
		
		Produto p3 = new ProdutoUnitario("Pendrive SanDisk", 35.50, desconto, "pendrive Sandisk de 16GB");
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		
		if (desconto.getValorDesconto() > 100) {
			System.out.println("[ERRO] Desconto maior que o valor total do produto!");
			
		} else {
			Produto kit = new ProdutoComposto("Kit de informática",  "kit com um notebook Dell\nHD 500GB, RAM 8GB"
					+ "\nProcessador Intel Core i5 7th Gen.\n\nMouse Wireless, Resolução de 1200 DPI\nGarantia do Fabricante: 1 ano", 
					produtos);
			
			CalculadorPreco calcPreco = new CalculadorPreco(kit, desconto);
			calcPreco.valorDeCobranca(kit);
		}
	}
}