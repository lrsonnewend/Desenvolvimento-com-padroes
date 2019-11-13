package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.engine.EngineServico;
import br.com.model.Servico;
import connectionSqlite.ConnectionDB;

/**
 * Classe responsavel pelos metodos para manipulacao dos servicos: criar,
 * remover, listar e alterar
 * 
 * @author lucas
 *
 */

public class ServicoDAO {

	ConnectionDB conDB = new ConnectionDB();
	EngineServico es = new EngineServico();

	/**
	 * Metodo construtor recebe uma nova conexao ao banco de dados quando é
	 * instanciado.
	 */

	public ServicoDAO() {
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

	public boolean createCliente() {
		Servico s = Servico.newServico();

		es.showMessage(s);

		String sql = "insert into servicos (nome_servico, valor_servico) values " + "(?,?);"; // string sql para
																								// execucao

		PreparedStatement stmt = conDB.newPreparedStmt(sql); // criando um stmt com atributos para ser executada no bd

		try {
			stmt.setString(1, s.getNome_servico());
			stmt.setDouble(2, s.getValor_servico());

			stmt.executeUpdate(); // mandando valores para executar o comando sql

			System.out.println("servico cadastrado.");

			return true;

		} catch (SQLException e) {
			System.err.println("erro ao inserir o servico: " + e);
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

	/**
	 * metodo para listar clientes
	 * 
	 * @param op - opcao de listagem
	 * 
	 */

	public void listServicos() {

		String sql = "select * from servicos order by nome_servico;";
		String cabecalho = "********** LISTANDO TODOS **********";

		ResultSet rs = null; // recebe os resultados da busca no bd
		Statement statement = null; // executa a string sql
		statement = conDB.newStatement();

		try {
			rs = statement.executeQuery(sql); // atribuindo os valores da consulta

			System.out.println(cabecalho);

			while (rs.next()) {
				System.out.println(rs.getInt("id_servico"));
				System.out.println("Nome: " + rs.getString("nome_servico"));
				System.out.println("Valor R$: " + rs.getString("valor_Servico"));

			}

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
	
	

	/**
	 * metodo para deletar um cliente
	 * 
	 * @param id - recebe o id do cliente a ser removido
	 * @return true - se o cliente foi removido. false - se o cliente nao foi
	 *         removido
	 */

//	public boolean deleteCliente(int id) {
//
//		PreparedStatement stmt = null;
//		String sql = "delete from clientes where id_cliente = ?"; // string com sql a ser executada
//
//		try {
//			stmt = conDB.newPreparedStmt(sql); // criando um novo stmt para executar a sql com o parametro id
//			stmt.setInt(1, id); // setando o valor no stmt
//			stmt.executeUpdate(); // executando a query sql
//
//			System.out.println("cliente deletado.");
//			return true;
//
//		} catch (SQLException e) {
//			System.err.println("erro ao deletar: " + e);
//			return false;
//		} finally { // metodo para fechar as conexoes com o banco
//			try {
//				stmt.close();
//				conDB.closeCon();
//
//			} catch (SQLException e) {
//				System.err.println("erro ao fechar conexoes: " + e);
//
//			}
//		}
//	}
//
//	public boolean updateCliente(int id) {
//		Cliente c = Cliente.newCliente();
//
//		ec.showMessage(c);
//
//		PreparedStatement stmt = null;
//		String sql = "update clientes set nome_cliente = ?, genero_cliente = ?, telefone_cliente = ?, "
//				+ "dataNasc_cliente = ? where id_cliente = ?;";
//
//		try {
//			stmt = conDB.newPreparedStmt(sql);
//			stmt.setString(1, c.getNome());
//			stmt.setString(2, c.getGenero());
//			stmt.setString(3, c.getTelefone());
//			stmt.setString(4, c.getDataNasc());
//			stmt.setInt(5, id);
//
//			stmt.executeUpdate();
//			System.out.println("alterado com sucesso.");
//			return true;
//
//		} catch (SQLException e) {
//			System.out.println("erro ao alterar cliente: " + e);
//			return false;
//		} finally {
//			try {
//				conDB.closeCon();
//				stmt.close();
//			} catch (SQLException e) {
//				System.out.println("erro ao fechar conexoes: " + e);
//			}
//		}
//	}
}
