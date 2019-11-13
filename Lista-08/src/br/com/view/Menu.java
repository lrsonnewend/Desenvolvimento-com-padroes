package br.com.view;

import javax.swing.JOptionPane;

/**
 * @author Gabriel, Lucas, Paulo
 * 
 */

public class Menu {
	
	public int menuCliente() {
		int op = Integer.parseInt(JOptionPane.showInputDialog("1-CADASTRO\n2-LISTAR CLIENTES\n3-REMOVER UM CLIENTE"
				+ "\n4-EDITAR CLIENTE\n5-RELATORIO\n0-Sair"));
		
		return op;
	}
	
	public int menuCarro() {
		int op = Integer.parseInt(JOptionPane.showInputDialog("1- CADASTRO\n2-LISTAR CARROS\n0-SAIR"));
		return op;
	}

	public int menuPrincipal() {
		int op = Integer.parseInt(JOptionPane.showInputDialog("1-Cliente\n2-Servico\n0-Sair"));
		return op;
	}
}
