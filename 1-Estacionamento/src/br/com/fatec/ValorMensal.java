package br.com.fatec;

public class ValorMensal implements CalculoValor{
	private final double mes = 2592E6;
	
	@Override
	public double valorConta(long tempo, Veiculo veiculo, double taxa) {
		return taxa * Math.ceil(tempo/mes);
	}

}
