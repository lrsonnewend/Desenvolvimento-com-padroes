package br.com.engine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.model.DAO.AgendamentoDAO;
import br.com.model.DAO.CarroDAO;
import br.com.model.DAO.ClienteDAO;

public class EngineData {

	ClienteDAO cliDAO = new ClienteDAO();
	CarroDAO carDAO = new CarroDAO();
	AgendamentoDAO ageDAO = new AgendamentoDAO();

	public void salvaInfo() {
		try {
			cliDAO.salvaCliente();
			carDAO.salvaCarros();
			ageDAO.salvaAgendamento();
			JOptionPane.showMessageDialog(null, "As informacoes foram salvas no computador.");

		} catch (IOException e) {
			System.err.println("erro ao salvar informações no disco: "+e);
		}
	}
}
