package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connectionSqlite.ConnectionDB;

public class CliCarDAO {
	ConnectionDB conDB = new ConnectionDB();

	public CliCarDAO() {
		conDB.connection();
	}

	public boolean relacionaCliCar() {
		int idCli = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: "));
		int idCar = Integer.parseInt(JOptionPane.showInputDialog("ID do carro: "));

		String sql = "insert into cliente_carro (idCliente, idCarro) values (?, ?);"; // string sql para execucao

		PreparedStatement stmt = conDB.newPreparedStmt(sql); // criando um stmt com atributos para ser executada no bd

		try {
			stmt.setInt(1, idCli);
			stmt.setInt(2, idCar);
			stmt.executeUpdate(); // mandando valores para executar o comando sql

			System.out.println("relacionamento feito.");

			return true;

		} catch (SQLException e) {
			System.err.println("erro no relacionamento: " + e);
			return false;

		} finally { // metodo para fechar conexoes com o bd
			if (stmt != null) {
				try {
					conDB.closeCon();
					stmt.close();

				} catch (SQLException e) {
					System.err.println("erro ao fechar prepared statement:" + e);
				}
			}
		}
	}

}
