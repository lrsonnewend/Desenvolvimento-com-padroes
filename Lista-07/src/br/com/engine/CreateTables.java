package br.com.engine;

import java.sql.Statement;
import java.sql.SQLException;

import connectionSqlite.ConnectionDB;

public class CreateTables {

	private ConnectionDB conBD = null;

	public CreateTables(ConnectionDB pConnectionDB) {
		this.conBD = pConnectionDB;
		
		String sql = "UPDATE clientes SET genero_cliente = 'M' WHERE id_cliente = 1;";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	/**
	 * metodo para criar a tabela cliente no banco
	 */
	public void createTableClientes() {
		String sql = "create table if not exists clientes" + "(" + "id_cliente integer PRIMARY KEY AUTOINCREMENT,"
				+ "nome_cliente varchar(40) NOT NULL," + "genero_cliente char(1)," + "telefone_cliente varchar(9),"
				+ "dataNasc_cliente date" + ");";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	public void createTableServicos() {
		String sql = "create table if not exists servicos" + "(" + "id_servico integer PRIMARY KEY AUTOINCREMENT,"
				+ "nome_servico varchar(40) NOT NULL," + "valor_servico decimal(4,2)" + ");";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	public void tableClienteXServico() {
		String sql = "create table if not exists cliente_servico"
				+ "("
				+ "idClienteServico integer PRIMARY KEY AUTOINCREMENT," + "id_cliente integer," + "id_servico integer,"
				+ "FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),"
				+ "FOREIGN KEY (id_servico) REFERENCES servicos (id_servico));";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}
}
