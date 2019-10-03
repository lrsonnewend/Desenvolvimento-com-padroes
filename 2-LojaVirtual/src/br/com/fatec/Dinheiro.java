package br.com.fatec;

public class Dinheiro implements Desconto {
	private double valorMoney;

	@Override
	public double precoFinal(double valor, double valorMoney) {
		return valor - valorMoney;
	}
	
	public double getValorMoney() {
		return valorMoney;
	}
	
	public Dinheiro(double valorMoney) {
		super();
		this.valorMoney = valorMoney;
	}
}
