package br.com.fatec;

import java.util.List;

public class Arroba implements Calculador{
	
	@Override
	public double CalculaPreco(List<Animais> animais) {
		double pesoFinal = 0.00;
		for(Animais a: animais) {
			pesoFinal += (160.50 *a.getPeso());
		}
		return pesoFinal;
	}
	
	
}
