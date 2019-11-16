package br.com.engine;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.ClienteXServico;
import br.com.model.DAO.CliServDAO;
import br.com.model.DAO.RelatorioDAO;

public class EngineCS {

	ClienteXServico cs = ClienteXServico.newCS();

	public void showMessage(ClienteXServico cs) {
		cs.setIdCliente(Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:")));

		cs.setIdServico(Integer.parseInt(JOptionPane.showInputDialog("ID do servico:")));

	}

	public int getIDCliente() {
		return Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));
	}
	
	public int listarMaisProcurado() {
		return Integer.parseInt(JOptionPane.showInputDialog("1-GERAL\n2-MASCULINO\n3-FEMININO"));
	}
	
	

	public void lidaOpcaoCS(int op) {
		CliServDAO dao = new CliServDAO();
		RelatorioDAO rdao = new RelatorioDAO();
		if (op == 1) {
			dao.listClientes(getIDCliente());
		}
		
		if(op == 2) {
			rdao.servicoMaisProcurado(listarMaisProcurado());
		}
	}
}
