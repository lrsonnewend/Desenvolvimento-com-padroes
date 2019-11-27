package br.com.model.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.engine.EngineCliente;
import br.com.model.Cliente;
import connectionSqlite.ConnectionDB;

/**
 * Classe responsavel pelos metodos para manipulacao dos clientes: criar,
 * remover, listar e alterar
 * 
 * @author Gabriel Carvalho, Lucas Ribeiro, Paulo Henrique
 */

public class ClienteDAO {

	ConnectionDB conDB = new ConnectionDB();
	EngineCliente ec = new EngineCliente();

	/**
	 * Metodo construtor recebe uma nova conexao ao banco de dados quando é
	 * instanciado.
	 */

	public ClienteDAO() {
		conDB.connection();
	}

	/**
	 * @param cliente - objeto Cliente para fazer a criacao.
	 * 
	 * @return true - se o cliente for cadastrado. false - se o cliente nao for
	 *         cadastrado.
	 */

	public boolean createCliente() {
		Cliente c = Cliente.newCliente();

		ec.showMessage(c);

		String sql = "insert into clientes (nome_cliente, telefone_cliente, endereco_cliente, " + "cpf_cliente) values "
				+ "(?,?,?,?);"; // string sql para execucao

		PreparedStatement stmt = conDB.newPreparedStmt(sql); // criando um stmt com atributos para ser executada no bd

		try {
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getCpf());

			stmt.executeUpdate(); // mandando valores para executar o comando sql

			System.out.println("cliente cadastrado.");

			return true;

		} catch (SQLException e) {
			System.err.println("erro ao inserir pessoa: " + e);
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

	public void listClientes() {

		String sql = null; // string para ser executada no banco de dados

		sql = "select * from clientes;";

		ResultSet rs = null; // recebe os resultados da busca no bd
		Statement statement = null; // executa a string sql
		statement = conDB.newStatement();

		try {
			rs = statement.executeQuery(sql); // atribuindo os valores da consulta

			while (rs.next()) {
				System.out.println(rs.getInt("id_cliente"));
				System.out.println("Nome: " + rs.getString("nome_cliente"));
				System.out.println("Telefone: " + rs.getString("telefone_cliente"));
				System.out.println("Endereco: " + rs.getString("endereco_cliente"));
				System.out.println("CPF: " + rs.getString("cpf_cliente") + "\n");

			}

		} catch (SQLException e) {
			System.err.println("erro ao listar todos os clientes: " + e);

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

	public boolean deleteCliente(int id) {

		PreparedStatement stmt = null;
		String sql = "delete from clientes where id_cliente = ?"; // string com sql a ser executada

		try {
			stmt = conDB.newPreparedStmt(sql); // criando um novo stmt para executar a sql com o parametro id
			stmt.setInt(1, id); // setando o valor no stmt
			stmt.executeUpdate(); // executando a query sql

			System.out.println("cliente deletado.");
			return true;

		} catch (SQLException e) {
			System.err.println("erro ao deletar: " + e);
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

	public boolean updateCliente(int id) {
		Cliente c = Cliente.newCliente();

		ec.showMessage(c);

		PreparedStatement stmt = null;
		String sql = "update clientes set nome_cliente = ?, telefone_cliente = ?, endereco_cliente = ?, "
				+ "cpf_cliente = ? where id_cliente = ?;";

		try {
			stmt = conDB.newPreparedStmt(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getCpf());
			stmt.setInt(5, id);

			stmt.executeUpdate();
			System.out.println("alterado com sucesso.");
			return true;

		} catch (SQLException e) {
			System.out.println("erro ao alterar cliente: " + e);
			return false;
		} finally {
			try {
				conDB.closeCon();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("erro ao fechar conexoes: " + e);
			}
		}
	}
	
	public void salvaCliente() throws IOException {

			String sql = null; // string para ser executada no banco de dados

			sql = "select * from clientes;";

			ResultSet rs = null; // recebe os resultados da busca no bd
			Statement statement = null; // executa a string sql
			statement = conDB.newStatement();

			try {
				rs = statement.executeQuery(sql); // atribuindo os valores da consulta
				PrintWriter pw = new PrintWriter(new FileWriter("/home/lucas/Documentos/info.txt", true));
				pw.println();
				pw.println("CLIENTES");
				while (rs.next()) {
					pw.println();
					pw.println(rs.getInt("id_cliente"));
					pw.println("Nome: " + rs.getString("nome_cliente"));
					pw.println("Telefone: " + rs.getString("telefone_cliente"));
					pw.println("Endereco: " + rs.getString("endereco_cliente"));
					pw.println("CPF: " + rs.getString("cpf_cliente") + "\n");
					pw.println();
					pw.println();
				}
				
				pw.println("##################");
				pw.flush();
				pw.close();
				
			} catch (SQLException e) {
				System.err.println("erro ao listar todos os clientes: " + e);

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
