package br.com.fatec;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Animais> animais = new ArrayList<Animais>();

		Scanner input = new Scanner(System.in); 
		int i;

		while (true) {
			System.out.println("[1] Cadastro de Animais\n[2] Calcular preço\n[3] Ver cadastros\n[4] Sair");
			i = input.nextInt();

			if (i == 1) {
				double peso = 0.00;
				String cat;
				Animais animal = Animais.getInstancia();
				System.out.println("Categoria (Bovino/Suino): ");
				cat = input.next();
				animal.setCategoria(cat);

				System.out.println("Peso do animal: ");
				String pesoStr = input.next();
				animal.setPeso(Double.parseDouble(pesoStr.replace(",", ".")));

				animais.add(animal);
			}

			else if (i == 2) {
				System.out.println("1-Kg\n2-Arroba");
				int tipoPeso = input.nextInt();
				if (tipoPeso == 1) {
					Quilo kg = new Quilo();
					System.out.println("R$"+kg.CalculaPreco(animais));
				}
				
				else {
					Arroba a = new Arroba();
					System.out.println("R$"+a.CalculaPreco(animais));
					
				}

			}

			else if (i == 3) {

				if (animais.size() == 0)
					System.out.println("Nenhum animal cadastrado.");

				else {

					for (Animais a : animais) {
						System.out.println("Categoria: " + a.getCategoria());
						System.out.println("Peso: " + a.getPeso() + "\n");
					}
				}
			}
			
			else if(i == 4)
				break;

		}
	}
}
