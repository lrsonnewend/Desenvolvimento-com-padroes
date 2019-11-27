package br.com.engine;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import br.com.model.Cliente;
import br.com.model.DAO.ClienteDAO;
import br.com.model.DAO.RelatorioDAO;
import br.com.model.DAO.ServicoDAO;

public class EngineData {
	ClienteDAO cliDAO = new ClienteDAO();
	ServicoDAO servDAO = new ServicoDAO();
	RelatorioDAO rDAO = new RelatorioDAO();
	
	public String salvaDir() {
		return JOptionPane.showInputDialog("Digite o caminho para salvar o arquivo com os dados");
	}
	
	public void salvaInfo() {
		//String caminho = salvaDir();
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(salvaDir()));
			
			bfw.write("****Clientes*****");
			bfw.newLine();			
			for(Cliente c: cliDAO.listClientes(1)) {
				bfw.write("Nome: "+c.getNome());
				bfw.newLine();
				bfw.write("Genero: "+c.getGenero());
				bfw.newLine();
				bfw.write("Data de nascimento: "+c.getDataNasc());
				bfw.newLine();
				bfw.write("Telefone: "+c.getTelefone());
				bfw.newLine();
				bfw.write("##########################");
				bfw.newLine();
				bfw.newLine();
				bfw.newLine();

			}
			
			bfw.flush();
			bfw.close();
			
			JOptionPane.showMessageDialog(null,"os dados foram salvos.");
			
		} catch (IOException e) {
			System.err.println("Erro ao salvar dados: "+e);
		}
	}
}
		
