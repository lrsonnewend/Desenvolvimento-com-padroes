package br.com.view;

import java.io.IOException;
import java.text.ParseException;

import br.com.engine.CreateTables;
import br.com.engine.EngineAgendamento;
import br.com.engine.EngineCarro;
import br.com.engine.EngineCliente;
import br.com.engine.EngineData;
import br.com.model.DAO.CliCarDAO;
import br.com.model.DAO.RelatorioDAO;
import connectionSqlite.ConnectionDB;

public class Main {
	public static void main(String[] args) throws ParseException, IOException {
		EngineCliente ec = new EngineCliente();
		EngineCarro ecar = new EngineCarro();
		EngineAgendamento eag = new EngineAgendamento();
		EngineData edata = new EngineData();
		Menu menu = new Menu();
		CliCarDAO daoCliCar = new CliCarDAO();
		RelatorioDAO rDao = new RelatorioDAO();

/*		ConnectionDB conDB = new ConnectionDB();
		CreateTables ctb = new CreateTables(conDB);

		ctb.createTableCarros();
		ctb.createTableClientes();
		ctb.createTableCliXCar();
		ctb.createTableRevisao();*/
		
		while (true) {
			int op = menu.menuPrincipal();

			if (op == 1) {
				int retorno = menu.menuCliente();
				ec.lidaOpcaoCliene(retorno);
			}

			else if (op == 2) {
				int retorno = menu.menuCarro();
				ecar.lidaOpcaoCarro(retorno);
				
			}

			else if (op == 3) {
				int retorno = menu.menuAge();
				eag.lidaOpcaoAge(retorno);
			}
			
			else if(op == 4) {
				daoCliCar.relacionaCliCar();			
			}
			
			else if(op == 5) {
				rDao.relatorio();
			}
			
			else if(op == 6) {
				edata.salvaInfo();				
			}

			else if (op == 0)
				break;
		}
	}
}
