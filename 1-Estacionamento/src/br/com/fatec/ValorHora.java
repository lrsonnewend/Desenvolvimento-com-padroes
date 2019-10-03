package br.com.fatec;

public class ValorHora implements CalculoValor{
	private final double hora = 3600000;

	@Override
	public double valorConta(long tempo, Veiculo veiculo, double taxa) {
		return taxa * Math.ceil(tempo / hora);
	}

}
