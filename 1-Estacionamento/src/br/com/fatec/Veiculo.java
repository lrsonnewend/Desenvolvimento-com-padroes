package br.com.fatec;

public class Veiculo {
	int qtdPessoas;
	String tipoVeiculo;
	int categoria;
	
	public String verificaVeiculo(int pessoas) {
		if(pessoas <= 2) 
			return "Motoca";
		
		else if(pessoas > 2 && pessoas <= 5 ) 
			return "Carro";
		
		else if(pessoas > 5 && pessoas <= 15) 
			return "Van";
		
		else 
			return "Busao";
	}
	
}
