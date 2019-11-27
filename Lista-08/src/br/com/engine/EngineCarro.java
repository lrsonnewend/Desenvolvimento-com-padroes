package br.com.engine;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.model.Carro;
import br.com.model.DAO.CarroDAO;

/**
 * @author Gabriel Carvalho, Lucas Ribeiro, Paulo Henrique
 */

public class EngineCarro {
	Carro servico = Carro.newServico();
	
	public void showMessage(Carro carro) {
		carro.setNumeroPlaca(JOptionPane.showInputDialog("Numero da placa:"));
		carro.setModelo(JOptionPane.showInputDialog("Modelo:"));
		carro.setAnoFabricacao(JOptionPane.showInputDialog("Ano de fabricacao:"));
		carro.setValorCompra(Double.parseDouble(JOptionPane.showInputDialog("Valor R$:")));
	}
	
	public void lidaOpcaoCarro(int op) throws IOException {
		CarroDAO dao = new CarroDAO();

		if (op == 1)
			dao.createCarro();

		else if (op == 2) {
			dao.listCarros();
			dao.salvaCarros();
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
