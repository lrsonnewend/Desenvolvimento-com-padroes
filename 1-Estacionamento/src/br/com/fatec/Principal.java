package br.com.fatec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Veiculo v = new Veiculo();
		int pessoas = 0, eixo = 0;
		int categoria;
		double valorCarga = 0;
		long periodo;
		
		java.util.Scanner reader = new java.util.Scanner(System.in);
		ContaEstacionamento ce = new ContaEstacionamento();
		
		System.out.println("Insira a categoria do Veículo: \n"
				+ "1 - Veículo de passeio\n"
				+ "2 - Veículo de carga");
		
		v.categoria = reader.nextInt();
		
		System.out.println("Quanto tempo o veículo ficará (em horas)?");
		periodo = reader.nextLong();
				
				
		if (v.categoria == 1) {
			System.out.println("Quantidade de pessoas: ");
			pessoas = reader.nextInt();
			
			v = new Passeio(pessoas);
			System.out.println("Veículo: " + v.verificaVeiculo(pessoas));
		}

		
		else if (v.categoria == 2) {
			System.out.println("quantidade de eixos: ");
			eixo = reader.nextInt();
			
			System.out.println("Valor da carga. R$: ");
			valorCarga = reader.nextFloat();
			
			v = new Carga(eixo, valorCarga);
			
			System.out.println("Veículo com " + eixo + " eixos");
		}
		
		ce.veiculo = v;
		ce.pessoas = pessoas;
		ce.eixo = eixo;
		ce.valorCarga = valorCarga;
		ce.valorConta(periodo);		
	}
}
