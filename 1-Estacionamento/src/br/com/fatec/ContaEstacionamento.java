package br.com.fatec;

import org.omg.CosNaming.IstringHelper;

public class ContaEstacionamento {
	private CalculoValor calculo;
	public Veiculo veiculo;
	public int pessoas, eixo;
	public double valorCarga, taxa = 0;
	double preco;
	
	
	public void valorConta(long periodo) {		
		periodo *= 3600000;
		
		// Passeio
		if (veiculo instanceof Passeio) {
			taxa = calcTaxa(pessoas);

			if((15*24*3600000) < periodo) {
				calculo = new ValorMensal();
				taxa *= 100;
				preco = calculo.valorConta(periodo, veiculo, taxa);
			}
			
			else if((12*3600000) < periodo) {
				calculo = new ValorDiaria();
				if (pessoas > 15)
					taxa *= 25;
				else
					taxa *= 20;
				preco = calculo.valorConta(periodo, veiculo, taxa);
			}
			
			else if ((12*3600000) >= periodo) {
				calculo = new ValorHora();
				taxa *= 2;
				preco = calculo.valorConta(periodo, veiculo, taxa);
				
			}
			System.out.println("Taxa Aplicada: " + taxa);
		}
		
		// Carga
		else {
			
			if(periodo > (15*24*3600000)) {
				calculo = new ValorMensal();
				taxa = 200*eixo;
				preco = calculo.valorConta(periodo, veiculo, taxa);
			}
					
			else if(periodo > (12*3600000)) {
				calculo = new ValorDiaria();
				taxa = 35*eixo;
				preco = calculo.valorConta(periodo, veiculo, taxa);
			}
				
			else if (periodo <= (12*3600000)) {
				calculo = new ValorHora();
				taxa = 4*eixo;
				preco = calculo.valorConta(periodo, veiculo, taxa);
			}
			double taxa = taxaCaminhao(eixo, valorCarga);
			preco += taxa;
			System.out.println("Taxa Aplicada: " + (valorCarga*0.1));
		}
		System.out.println("Preço: R$ "+ preco);
	}
	
	public double calcTaxa(int pessoas) {
		int taxa;
		
		if(pessoas <= 5) 
			taxa = 1;
		
		else if(pessoas > 5 && pessoas <= 15) 
			taxa = 3;

		else 
			taxa = 5;
		
		return taxa;
	}
	
	public double taxaCaminhao(int eixos, double valorCarga) {
		if (valorCarga == 0)
			valorCarga = 1;
		double taxa = (valorCarga*0.1);

		return taxa;
	}
	
	public void setCalculo(CalculoValor calculo) {
		this.calculo = calculo;
	}
	
}
