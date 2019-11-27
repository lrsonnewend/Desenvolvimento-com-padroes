package br.com.model.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.engine.EngineAgendamento;
import br.com.model.Agendamento;
import connectionSqlite.ConnectionDB;

public class AgendamentoDAO {

	ConnectionDB conDB = new ConnectionDB();
	EngineAgendamento eag = new EngineAgendamento();

	public AgendamentoDAO() {
		conDB.connection();
	}

	public boolean createAge() {
		Agendamento age = Agendamento.newAgendamento();

		eag.showMessage(age);
		int idFKCli = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));
		int idFKCar = Integer.parseInt(JOptionPane.showInputDialog("ID do carro:"));
		
		String sql = "insert into agendamentos (idCliente, idCarro, data_revisao, descricao_revisao) values (?, ?, ?, ?);"; // string
																												// sql
																												// para
																												// execucao

		PreparedStatement stmt = conDB.newPreparedStmt(sql); // criando um stmt com atributos para ser executada no bd

		try {
			stmt.setInt(1, idFKCli);
			stmt.setInt(2, idFKCar);
			stmt.setString(3, age.getDataAg());
			stmt.setString(4, age.getDescricaoAg());

			stmt.executeUpdate(); // mandando valores para executar o comando sql

			System.out.println("agendamento realizado.");

			return true;

		} catch (SQLException e) {
			System.err.println("erro ao inserir o possante: " + e);
			return false;

		} finally { // metodo para fechar conexoes com o bd
			if (stmt != null) {
				try {
					stmt.close();
					conDB.closeCon();

				} catch (SQLException e) {
					System.err.println("erro ao fechar prepared statement:" + e);
				}
			}
		}
	}

	public boolean updateDataAge(int id) {
		String newDate = JOptionPane.showInputDialog("Insira a nova data");
		String sql = "update agendamentos set data_agendamento = ? where idRevisao = ?;";

		PreparedStatement stmt = null;

		try {
			stmt = conDB.newPreparedStmt(sql);
			stmt.setString(1, newDate);
			stmt.setInt(2, id);
			stmt.executeUpdate();

			System.out.println("data alterada.");
			return true;
		} catch (SQLException e) {
			System.err.println("erro ao alterar data: " + e);
			return false;
		} finally {
			try {
				conDB.closeCon();
				stmt.close();
			} catch (SQLException e) {
				System.err.println("erro ao fechar conexoes: " + e);
			}
		}
	}

	public boolean deleteAge(int id) {
		PreparedStatement stmt = null;
		String sql = "delete from agendamentos where idRevisao = ?"; // string com sql a ser executada

		try {
			stmt = conDB.newPreparedStmt(sql); // criando um novo stmt para executar a sql com o parametro id
			stmt.setInt(1, id); // setando o valor no stmt
			stmt.executeUpdate(); // executando a query sql

			System.out.println("agendamento cancelado.");
			return true;

		} catch (SQLException e) {
			System.err.println("erro ao deletar agendamento: " + e);
			return false;
		} finally { // metodo para fechar as conexoes com o banco
			try {
				stmt.close();
				conDB.closeCon();

			} catch (SQLException e) {
				System.err.println("erro ao fechar conexoes: " + e);
			}
		}
	}
	
	
	public void salvaAgendamento() throws IOException {
		String sql = "select ag.idrevisao,\r\n" + "	   cli.nome_cliente,\r\n" + "       c.modelo,\r\n"
				+ "       ag.descricao_revisao,\r\n" + "       ag.data_revisao\r\n" + "from agendamentos ag\r\n"
				+ "LEFT JOIN carros c on c.id_carro = ag.idcarro\r\n"
				+ "LEFT JOIN clientes cli on cli.id_cliente = ag.idcliente";

		ResultSet rs = null; // recebe os resultados da busca no bd
		Statement statement = null; // executa a string sql
		statement = conDB.newStatement();

		try {
			rs = statement.executeQuery(sql); // atribuindo os valores da consulta
			PrintWriter pw = new PrintWriter(new FileWriter("/home/lucas/Documentos/info.txt", true));
			pw.println();
			pw.println("AGENDAMENTOS");
			
			while (rs.next()) {
				pw.println();				
				pw.println(rs.getInt("idRevisao"));
				pw.println("Nome: " + rs.getString("nome_cliente") + "\n");
				pw.println("Modelo: " + rs.getString("modelo") + "\n");
				pw.println("Descricao: " + rs.getString("descricao_revisao") + "\n");
				pw.println("Data da revisao: " + rs.getString("data_revisao") + "\n");

			}
			pw.println("##################");
			pw.flush();
			pw.close();

		} catch (SQLException e) {
			System.err.println("erro ao listar todos os servicos: " + e);

		} finally { // metodo para fechar as conexoes com o bd
			try {
				statement.close();
				rs.close();
				conDB.closeCon();

			} catch (SQLException e) {
				System.err.println("erro ao fechar resultSet: " + e);
			}
		}
	}	
	
}
