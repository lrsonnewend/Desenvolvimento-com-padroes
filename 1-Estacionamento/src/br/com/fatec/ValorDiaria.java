package br.com.fatec;

public class ValorDiaria implements CalculoValor{
	private final double dia = 86400000;
	
	@Override
	public double valorConta(long tempo, Veiculo veiculo, double taxa) {
		return taxa * Math.ceil(tempo / dia);
	}
}
