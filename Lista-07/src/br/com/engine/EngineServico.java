package br.com.engine;

import javax.swing.JOptionPane;

import br.com.model.Servico;
import br.com.model.DAO.ServicoDAO;

public class EngineServico {
	Servico servico = Servico.newServico();
	
	public void showMessage(Servico servico) {
		servico.setNome_servico(JOptionPane.showInputDialog("Nome:").toUpperCase());
		servico.setValor_servico(Double.parseDouble(JOptionPane.showInputDialog("Valor R$:")));
	}
	
	public void lidaOpcaoServico(int op) {
		ServicoDAO dao = new ServicoDAO();

		if (op == 1)
			dao.createServico();

		else if (op == 2) {
			dao.listServicos();
		}

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
