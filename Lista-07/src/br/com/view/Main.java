package br.com.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.engine.CreateTables;
import br.com.engine.EngineCliente;
import br.com.engine.EngineServico;
import br.com.model.Cliente;
import br.com.model.DAO.ClienteDAO;
import connectionSqlite.ConnectionDB;

public class Main{
	public static void main(String[] args) throws ParseException {
		EngineCliente ec = new EngineCliente();
		EngineServico es = new EngineServico();
		Menu menu = new Menu();
		ConnectionDB cdb = new ConnectionDB();
		

		while (true) {
			ClienteDAO dao = new ClienteDAO();
			int op = menu.menuPrincipal();
			
			if(op == 1) {
				int retorno = menu.menuCliente();
				ec.lidaOpcaoCliene(retorno);
			}
			
			else if(op == 2) {
				int retorno = menu.menuServico();
				es.lidaOpcaoServico(retorno);
			}
			
			else if(op == 0)
				break;
		}
			

//		while (true) {
//
//			int op = Integer.parseInt(JOptionPane.showInputDialog("1-CADASTRO\n2-LISTAR CLIENTES\n3-REMOVER UM CLIENTE"
//					+ "\n4-EDITAR CLIENTE\n5-RELATORIO\n0-Sair"));
//
//			if (op == 1)
//				ec.create();
//
//			else if (op == 2) {
//				int opcao = Integer.parseInt(JOptionPane.showInputDialog("1-Listar todos\nListar por genero:\n"
//						+ " \t \t2-Feminino \n \t \t3-Masculino"));
//				dao.listClientes(opcao);
//			}
//			
//			else if(op == 3) {
//				int id = Integer.parseInt(JOptionPane.showInputDialog("id do cliente a ser removido: "));
//				
//				dao.deleteCliente(id);
//			}
//			else if(op == 4)
//				ec.update(clientes);
//
//			else if(op == 0)
//				break;
//		}
//
//	}
	}
}
