package br.com.engine;

import java.sql.Statement;
import java.sql.SQLException;

import connectionSqlite.ConnectionDB;

public class CreateTables {

	private ConnectionDB conBD = null;

	public CreateTables(ConnectionDB pConnectionDB) {
		this.conBD = pConnectionDB;
	}

	/**
	 * metodo para criar a tabela cliente no banco
	 */
	public void createTableClientes() {
		String sql = "create table if not exists clientes" + "(" + "id_cliente integer PRIMARY KEY AUTOINCREMENT,"
				+ "nome_cliente varchar(40) NOT NULL," + "telefone_cliente varchar(12),"
				+ "endereco_cliente varchar(50)," + "cpf_cliente varchar(13)" + ");";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela cliente no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	public void createTableCarros() {
		String sql = "create table if not exists carros" + "(" + "id_carro integer PRIMARY KEY AUTOINCREMENT,"
				+ "numero_placa varchar(10) NOT NULL," + "modelo varchar(30)," + "ano_fabricacao varchar(4),"
				+ "valor_compra real" + ");";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela carro no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	public void createTableCliXCar() {
		String sql = "create table if not exists cliente_carro" + "("
				+ "idCliCar integer PRIMARY KEY AUTOINCREMENT,"
				+ "idCliente integer," + "idCarro integer,"
				+ "FOREIGN KEY (idCliente) REFERENCES clientes (id_cliente),"
				+ "FOREIGN KEY (idCarro) REFERENCES carros (id_carro)" + ");";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela cliente_carro no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}

	public void createTableRevisao() {
		String sql = "create table if not exists agendamentos" + "(" + "idRevisao integer PRIMARY KEY AUTOINCREMENT,"
				+ "data_revisao date," + "descricao_revisao text," + "idCliente integer, idCarro integer,"
				+ "FOREIGN KEY (idCliente) REFERENCES clientes (id_cliente)" 
				+ "FOREIGN KEY (idCarro) REFERENCES carros (id_carro));";

		// executando o sql
		boolean execute = false;

		try {
			execute = this.conBD.connection();
			Statement stmt = this.conBD.newStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.err.println("erro ao criar tabela cliente_carro no bd: " + e);

		} finally {
			if (execute)
				this.conBD.closeCon();
		}
	}
}
