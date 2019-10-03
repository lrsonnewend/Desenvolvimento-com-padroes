package br.com.fatec;

public class CalculoValor {
	double VlFinal = 0;
	public double calculaPreco(double valorProduto, double VlDesconto){
		VlFinal = valorProduto - VlDesconto;
		
		
		return VlFinal;
	}
}
