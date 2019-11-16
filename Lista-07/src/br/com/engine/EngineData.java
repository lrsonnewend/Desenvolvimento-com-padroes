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
		

//		// Data de hoje.
//		GregorianCalendar hoje = new GregorianCalendar();
//		int diah = hoje.get(Calendar.DAY_OF_MONTH);
//		int mesh = hoje.get(Calendar.MONTH) + 1;
//		int anoh = hoje.get(Calendar.YEAR);
//
//		// Data do nascimento.
//		int dian = Integer.valueOf(dt_nasc.substring(0, 2));
//		int mesn = Integer.valueOf(dt_nasc.substring(3, 5));
//		int anon = Integer.valueOf(dt_nasc.substring(6, 10));
//
//		// Idade.
//		int idade;
//
//		if (mesn < mesh || (mesn == mesh && dian <= diah))
//			idade = anoh - anon;
//		else
//			idade = (anoh - anon) - 1;
//
//		return (idade);
//	}
