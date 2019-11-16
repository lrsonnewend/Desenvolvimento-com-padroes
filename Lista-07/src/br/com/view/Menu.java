package br.com.view;

import javax.swing.JOptionPane;


public class Menu {
	
	public int menuCliente() {
		
		return Integer.parseInt(JOptionPane.showInputDialog("1-CADASTRO\n2-LISTAR CLIENTES\n3-REMOVER UM CLIENTE"
				+ "\n4-EDITAR CLIENTE\n0-Sair"));
	}
	
	public int menuServico() {
		return Integer.parseInt(JOptionPane.showInputDialog("1- CADASTRO\n2-LISTAR SERVICOS\n0-SAIR"));
	}

	public int menuPrincipal() {
		return Integer.parseInt(JOptionPane.showInputDialog("1-CLIENTE\n2-SERVICO\n3-RELACIONAR CLIENTE/SERVICO\n"
				+ "4-RELATORIO\n5-SALVAR INFORMACOES EM DISCO\n0-Sair"));
	}
	
	public int menuRelatorio() {
		return  Integer.parseInt(JOptionPane.showInputDialog("1-LISTAR SERVICOS POR CLIENTE\n2-SERVICO MAIS PROCURADO"));
	}
	
	
}
