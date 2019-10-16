package br.com.fatec;

import java.util.List;

public class Quilo implements Calculador{
	
	@Override
	public double CalculaPreco(List<Animais> animais) {
		double pesoFinal = 0.00;
		for(Animais a: animais) {
			pesoFinal += (10.7*a.getPeso());
		}
		return pesoFinal;
	}
}
