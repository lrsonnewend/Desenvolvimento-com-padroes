package br.com.fatec;

public class Porcentagem implements Desconto {
	private int descPerc;

	@Override
	public double precoFinal(double valor, double descPerc) {
		return valor - valor * (descPerc / 100);
	}

	public Porcentagem(int descPerc) {
		super();
		this.descPerc = descPerc;
	}

	public int getDesconto() {
		return descPerc;
	}

}
