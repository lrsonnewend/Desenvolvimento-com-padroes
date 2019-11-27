package br.com.engine;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.DAO.ClienteDAO;

public class EngineCliente {
	Cliente cliente = Cliente.newCliente();

	public void showMessage(Cliente cliente) {
		cliente.setNome(JOptionPane.showInputDialog("Nome:").toUpperCase());
		cliente.setGenero(JOptionPane.showInputDialog("Genero:").toUpperCase());
		cliente.setDataNasc(JOptionPane.showInputDialog("Data de nascimento (yyy-MM-dd):"));
		cliente.setTelefone(JOptionPane.showInputDialog("Telefone: "));
	}

	public int typeList() {

		return Integer.parseInt(JOptionPane
				.showInputDialog("1-Listar todos\nListar por genero:\n" + " \t \t2-Feminino \n \t \t3-Masculino"));
	}

	public int selectId() {
		return Integer.parseInt(JOptionPane.showInputDialog("id do cliente a ser removido: "));

	}

	public void lidaOpcaoCliene(int op) {
		ClienteDAO dao = new ClienteDAO();

		if (op == 1)
			dao.createCliente();

		else if (op == 2) {
			List<Cliente> clientes = new ArrayList<>();
			clientes = dao.listClientes(typeList());
			for (Cliente c : clientes) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("Genero: " + c.getGenero());
				System.out.println("Data de nascimento: " + c.getDataNasc());
				System.out.println("Telefone: " + c.getTelefone() + "\n");
			}
		}

		else if (op == 3) {
			dao.deleteCliente(selectId());
		}

		else if (op == 4) {
			dao.updateCliente(selectId());
		}

		else if (op == 0) {

		}
	}
}
