package br.com.fatec;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int tipo;
		double valorDesconto = 0;
		double porcDesconto = 0;
		java.util.Scanner reader = new Scanner(System.in);

		Produto p1 = new Produto("TV Samsung 4K", 1500);
		CalculoValor c1 = new CalculoValor();
		
		System.out.println("Modo de desconto:\n1 - Porcentagem\n2 - Valor bruto");
		tipo = reader.nextInt();
		
		
		
		if(tipo == 1) {
			System.out.println("Porcentagem do desconto: ");
			porcDesconto = reader.nextDouble();
			
			valorDesconto = (porcDesconto/100)*p1.getValorProd();		
			
		}
		
		else if(tipo == 2) {
			System.out.println("Quantidade desconto: ");
			valorDesconto = reader.nextDouble();

		}
		System.out.println("Produto: " + p1.getNome() + "\n" + "Valor: " + p1.getValorProd());
		System.out.println("Valor Final: "+c1.calculaPreco(p1.getValorProd(), valorDesconto));
		System.exit(0);
	}
}