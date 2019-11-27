package br.com.engine;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.DAO.ClienteDAO;

public class EngineCliente {
	Cliente cliente = Cliente.newCliente();

	public void showMessage(Cliente cliente) {
		cliente.setNome(JOptionPane.showInputDialog("Nome:").toUpperCase());
		cliente.setTelefone(JOptionPane.showInputDialog("Telefone:"));
		cliente.setEndereco(JOptionPane.showInputDialog("Endereco: "));
		cliente.setCpf(JOptionPane.showInputDialog("CPF:"));
	}


	public int selectId() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id do cliente a ser removido: "));
		return id;
	}

	public void lidaOpcaoCliene(int op) {
		ClienteDAO dao = new ClienteDAO();

		if (op == 1)
			dao.createCliente();

		else if (op == 2) {
			dao.listClientes();
		}
//
//		else if (op == 3) {
//			int id = selectId();
//			dao.deleteCliente(id);
//
//		}
//
//		else if (op == 4) {
//			int id = selectId();
//			dao.updateCliente(id);
//		}

		else if (op == 0) {

		}
	}

}
