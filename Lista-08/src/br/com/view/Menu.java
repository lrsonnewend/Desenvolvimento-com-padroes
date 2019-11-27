package br.com.view;

import javax.swing.JOptionPane;

/**
 * @author Gabriel, Lucas, Paulo
 * 
 */

public class Menu {
	
	public int menuCliente() {
		return Integer.parseInt(JOptionPane.showInputDialog("1-CADASTRO\n2-LISTAR CLIENTES\n3-REMOVER UM CLIENTE"
				+ "\n4-EDITAR CLIENTE\n0-Sair"));
	}
	
	public int menuCarro() {
		return Integer.parseInt(JOptionPane.showInputDialog("1- CADASTRO\n2-LISTAR CARROS\n0-SAIR"));
	}
	

	public int menuAge() {
		return Integer.parseInt(JOptionPane.showInputDialog("1- FAZER AGENDAMENTO\n2-ALTERAR DATA\n3-CANCELAR AGENDAMENTO\n0-SAIR")); 
	}
	public int menuPrincipal() {
		return Integer.parseInt(JOptionPane.showInputDialog("1-CLIENTE\n2-CARROS\n3-AGENDAMENTOS"
				+ "\n4-RELACIONAR CLIENTE/CARRO\n5-RELATORIO\n6-SALVAR INFORMACOES\n0-SAIR"));
	}
}
