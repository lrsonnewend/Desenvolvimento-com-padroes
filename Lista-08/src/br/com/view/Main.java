package br.com.view;

import java.text.ParseException;
import br.com.engine.EngineCarro;
import br.com.engine.EngineCliente;

public class Main {
	public static void main(String[] args) throws ParseException {
		EngineCliente ec = new EngineCliente();
		EngineCarro ecar = new EngineCarro();
		Menu menu = new Menu();

		while (true) {
			int op = menu.menuPrincipal();

			if (op == 1) {
				int retorno = menu.menuCliente();
				ec.lidaOpcaoCliene(retorno);
			}

			else if (op == 2) {
				int retorno = menu.menuCarro();
				ecar.lidaOpcaoServico(retorno);
			}

			else if (op == 0)
				break;
		}
	}
}
