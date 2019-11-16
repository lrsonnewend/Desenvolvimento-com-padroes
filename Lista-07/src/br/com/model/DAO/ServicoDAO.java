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

	public boolean createServico() {
		Servico s = Servico.newServico();

		es.showMessage(s);

		String sql = "insert into servicos (nome_servico, valor_servico) values " + "(?,?);"; // string sql para execucao

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
	 * metodo para listar servicos
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
				System.out.println("Valor R$: " + rs.getString("valor_Servico")+"\n");

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
}