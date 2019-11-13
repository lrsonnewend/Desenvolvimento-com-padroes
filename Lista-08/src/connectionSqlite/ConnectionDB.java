package connectionSqlite;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe para fazer a conexao com o bd sqlite
 * 
 * @author Gabriel, Lucas, Paulo
 */

public class ConnectionDB {
	private Connection con = null;

	/**
	 * Conecta a um banco de dados (cria se o mesmo nao existir).
	 * 
	 * @return
	 */
	public boolean connection() {
		try {
			String url = "jdbc:sqlite:bd/lista8.db";
			this.con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("erro ao conectar ao banco: " + e);
			return false;
		}

		return true;
	}
	

	/**
	 * Metodo para desconectar do banco de dados.
	 * 
	 * @return
	 */

	public boolean closeCon() {
		try {
			if (this.con.isClosed() == false)
				this.con.close();
		} catch (SQLException e) {
			System.err.println("erro ao desconectar do banco: " + e);
			return false;
		}
		return true;
	}

	/**
	 * metodo para criar statements para executar sql's
	 * 
	 * @return novo statement para manipulacao do bd
	 */
	public Statement newStatement() {
		try {
			return this.con.createStatement();
		} catch (SQLException e) {
			System.err.println("erro ao criar statement: " + e);
			return null;
		}
	}
	
	/**
	 * cria prepared statements para executar sql's
	 * 
	 * @return novo prepared statement
	 */
	public PreparedStatement newPreparedStmt(String sql) {
		try {
			return this.con.prepareStatement(sql);
		}catch(SQLException e) {
			System.err.println("erro ao criar prepared statement: "+e);
			return null;
		}
	}

}
