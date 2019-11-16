package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.engine.EngineCS;
import br.com.engine.EngineCliente;
import br.com.model.Cliente;
import br.com.model.ClienteXServico;
import connectionSqlite.ConnectionDB;

public class CliServDAO {

	ConnectionDB conDB = new ConnectionDB();
	EngineCS ecs = new EngineCS();

	/**
	 * Metodo construtor recebe uma nova conexao ao banco de dados quando é
	 * instanciado.
	 */

	public CliServDAO() {
		conDB.connection();
	}

	/**
	 * 
	 * @param cliente - objeto Cliente para fazer a criacao.
	 * 
	 * @return true - se o cliente for cadastrado. false - se o cliente nao for
	 *         cadastrado.
	 * 
	 */

	public boolean createCS() {
		ClienteXServico cs = ClienteXServico.newCS();

		ecs.showMessage(cs);

		String sql = "insert into cliente_servico (id_cliente, id_servico) values (?,?);"; // string sql para execucao

		PreparedStatement stmt = conDB.newPreparedStmt(sql); // criando um stmt com atributos para ser executada no bd

		try {
			stmt.setInt(1, cs.getIdCliente());
			stmt.setInt(2, cs.getIdServico());

			stmt.executeUpdate(); // mandando valores para executar o comando sql

			System.out.println("cliente/servico relacionados.");

			return true;

		} catch (SQLException e) {
			System.err.println("erro ao relacionar cliente com servico: " + e);
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

	public void listClientes(int idCliente) {

		// servico consumido por cliente
		String sql = "select cs.idclienteservico,\r\n" + "       cs.id_cliente,\r\n" + "       c.nome_cliente, \r\n"
				+ "       cs.id_servico,\r\n" + "	   s.nome_servico\r\n" + "from cliente_servico cs\r\n"
				+ "inner JOIN servicos s on s.id_servico =  cs.id_servico\r\n"
				+ "inner JOIN clientes c on c.id_cliente = cs.id_cliente\r\n" + "where cs.id_cliente = " + idCliente; // string
																														// para
		ResultSet rs = null; // recebe os resultados da busca no bd
		Statement stmt = null; // executa a string sql
		stmt = conDB.newStatement();

		try {

			rs = stmt.executeQuery(sql); // atribuindo os valores da consulta

			System.out.println("Cliente: (" + rs.getInt("id_cliente") + "): " + rs.getString("nome_cliente"));
			while (rs.next()) {
				System.out.println("Servico: (" + rs.getInt("id_servico") + "): " + rs.getString("nome_servico")+"\n");

			}

		} catch (SQLException e) {
			System.err.println("erro ao listar todos os clientes: " + e);

		} finally { // metodo para fechar as conexoes com o bd
			try {
				stmt.close();
				rs.close();
				conDB.closeCon();

			} catch (SQLException e) {
				System.err.println("erro ao fechar resultSet: " + e);
			}
		}
	}
}
