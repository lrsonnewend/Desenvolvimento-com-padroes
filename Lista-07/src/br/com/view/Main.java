package br.com.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.engine.CreateTables;
import br.com.engine.EngineCS;
import br.com.engine.EngineCliente;
import br.com.engine.EngineData;
import br.com.engine.EngineServico;
import br.com.model.Cliente;
import br.com.model.DAO.CliServDAO;
import br.com.model.DAO.ClienteDAO;
import br.com.model.DAO.RelatorioDAO;
import connectionSqlite.ConnectionDB;

public class Main {
	public static void main(String[] args) throws ParseException {
		EngineCliente ec = new EngineCliente();
		EngineServico es = new EngineServico();
		EngineCS ecs = new EngineCS();
		EngineData data = new EngineData();
		Menu menu = new Menu();
		
//		ConnectionDB condb = new ConnectionDB();
//		CreateTables ctb = new CreateTables(condb);


		while (true) {
			CliServDAO csDAO = new CliServDAO();
			int opcao = menu.menuPrincipal();

			if (opcao == 1) {
				int op = menu.menuCliente();
				ec.lidaOpcaoCliene(op);
			}

			else if (opcao == 2) {
				int op = menu.menuServico();
				es.lidaOpcaoServico(op);
			}
			
			else if(opcao == 3) {
				csDAO.createCS();
			}
			
			else if(opcao == 4) {
				int op = menu.menuRelatorio();
				ecs.lidaOpcaoCS(op);
				
			}
			
			else if(opcao == 5) {
				data.salvaInfo();				
			}

			else if (opcao == 0)
				break;
		}

	}
}
