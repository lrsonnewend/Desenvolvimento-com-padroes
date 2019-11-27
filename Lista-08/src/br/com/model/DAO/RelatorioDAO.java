package br.com.model.DAO;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connectionSqlite.ConnectionDB;

public class RelatorioDAO {

	ConnectionDB conDB = new ConnectionDB();

	public RelatorioDAO() {
		conDB.connection();
	}

	public void relatorio() {
		int idCli = Integer.parseInt(JOptionPane.showInputDialog("id do cliente: "));

		String sql = "select ag.idrevisao,\r\n" + "	   cli.nome_cliente,\r\n" + "       c.modelo,\r\n"
				+ "       ag.descricao_revisao,\r\n" + "       ag.data_revisao\r\n" + "from agendamentos ag\r\n"
				+ "LEFT JOIN carros c on c.id_carro = ag.idcarro\r\n"
				+ "LEFT JOIN clientes cli on cli.id_cliente = ag.idcliente where ag.idcliente=" + idCli;

		ResultSet rs = null; // recebe os resultados da busca no bd
		Statement statement = null; // executa a string sql
		statement = conDB.newStatement();

		try {
			rs = statement.executeQuery(sql); // atribuindo os valores da consulta

			while (rs.next()) {
				System.out.println("-----------------------------");
				System.out.println(rs.getInt("idRevisao"));
				System.out.println("Nome: " + rs.getString("nome_cliente") + "\n");
				System.out.println("Modelo: " + rs.getString("modelo") + "\n");
				System.out.println("Descricao: " + rs.getString("descricao_revisao") + "\n");
				System.out.println("Data da revisao: " + rs.getString("data_revisao") + "\n");
				System.out.println("-----------------------------");

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
