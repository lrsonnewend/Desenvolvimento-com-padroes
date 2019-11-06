package br.com.fatec;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.engine.EngineCliente;

public class Main {
	public static void main(String[] args) throws ParseException {
		EngineCliente ec = new EngineCliente();
		Cliente c = Cliente.newCliente();
		List<Cliente> clientes = new ArrayList();
		
		/*Cliente c1 = Cliente.newCliente();
		Cliente c2 = Cliente.newCliente();
		Cliente c3 = Cliente.newCliente();
		
		c1.setNome("Afonso");
		c2.setNome("Aline");
		c3.setNome("Lucas");
		
		clientes.add(c3);
		clientes.add(c2);
		clientes.add(c1);*/
		
		
		while (true) {

			int op = Integer.parseInt(JOptionPane.showInputDialog("1-CADASTRO\n2-LISTAR CLIENTES"));

			if (op == 1)
				clientes = ec.create();

			else if (op == 2)
				ec.read(clientes);

			else
				break;
		}

	}

}
