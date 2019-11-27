package br.com.engine;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.model.Agendamento;
import br.com.model.Cliente;
import br.com.model.DAO.AgendamentoDAO;
import br.com.model.DAO.ClienteDAO;

public class EngineAgendamento {
	
	public void showMessage(Agendamento age) {
		age.setDescricaoAg(JOptionPane.showInputDialog("Descricao:"));
		age.setDataAg(JOptionPane.showInputDialog("Data da revisão:"));
	}
	
	public int selectId() {
		return Integer.parseInt(JOptionPane.showInputDialog("id do agendamento"));
	}
	
	public void lidaOpcaoAge(int op) {
		AgendamentoDAO dao = new AgendamentoDAO();

		if (op == 1)
			dao.createAge();

		else if (op == 2) {
			dao.updateDataAge(selectId());
			
		}
		
		else if (op == 3) {
			dao.deleteAge(selectId());
		}

		else if (op == 0) {

		}
	}


}
