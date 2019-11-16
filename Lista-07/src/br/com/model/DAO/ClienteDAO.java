package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.engine.EngineCliente;
import br.com.model.Cliente;
import connectionSqlite.ConnectionDB;

/**
 * Classe responsavel pelos metodos para manipulacao 
 * dos clientes: criar, remover, listar e alterar
 * @author lucas
 *
 */

public class ClienteDAO {
	
	ConnectionDB conDB = new ConnectionDB();
	EngineCliente ec = new EngineCliente();
	
	/**
	 * Metodo construtor
	 * recebe uma nova conexao ao banco de dados
	 * quando é instanciado.
	 */
	
	public ClienteDAO() {
		conDB.connection();
	}
	
	/**
	 * 
	 * @param cliente - objeto Cliente para fazer a criacao.
	 * 
	 * @return true - se o cliente for cadastrado. false - se o cliente nao for cadastrado. 
	 * 
	 */
	
	public boolean createCliente() {
		Cliente c = Cliente.newCliente();
		
		ec.showMessage(c);
				
		String sql = "insert into clientes (nome_cliente, genero_cliente, dataNasc_cliente, telefone_cliente) values "
				+ "(?,?,?,?);"; //string sql para execucao
		
		PreparedStatement stmt = conDB.newPreparedStmt(sql); //criando um stmt com atributos para ser executada no bd
		
		try {
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getGenero());
			stmt.setString(3, c.getDataNasc());
			stmt.setString(4, c.getTelefone());
			
			stmt.executeUpdate(); // mandando valores para executar o comando sql
			
			System.out.println("cliente cadastrado.");
			
			return true;
		
		}catch(SQLException e) {
			System.err.println("erro ao inserir pessoa: "+e);
			return false;
		
		}finally { //metodo para fechar conexoes com o bd
			if(stmt != null) {
				try {
					stmt.close();
					conDB.closeCon();

				}catch(SQLException e) {
					System.err.println("erro ao fechar prepared statement:"+e);
				}
			}
		}
	}
	
	
	/**
	 * metodo para listar clientes
	 * @param op - opcao de listagem
	 * 
	 */
	
	public List<Cliente> listClientes(int op){
		List <Cliente> clientes = new ArrayList<Cliente>();

		String sql = null; //string para ser executada no banco de dados
		
		if(op == 1) {
			sql = "select * from clientes order by nome_cliente;";
		}
		
		else if(op == 2) {
			sql = "select * from clientes where genero_cliente = 'f' or genero_cliente = 'F' order by nome_cliente;";
		}
		
		else if(op == 3) {
			sql = "select * from clientes where genero_cliente = 'm' or genero_cliente = 'M' order by nome_cliente;";
		}
		
		ResultSet rs = null; //recebe os resultados da busca no bd
		Statement statement = null; //executa a string sql 
		statement = conDB.newStatement();
		
		try{			
			rs = statement.executeQuery(sql); //atribuindo os valores da consulta 
						
			while(rs.next()) {
				Cliente c = Cliente.newCliente();
				c.setIdCliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome_cliente"));
				c.setGenero(rs.getString("genero_cliente"));
				c.setDataNasc(rs.getString("dataNasc_cliente"));
				c.setTelefone(rs.getString("telefone_cliente"));
				clientes.add(c);				
			}
			
		}catch(SQLException e) {
			System.err.println("erro ao listar todos os clientes: "+e);
			
		}finally { //metodo para fechar as conexoes com o bd 
			try {
				statement.close();
				rs.close();
				conDB.closeCon();
				
			}catch(SQLException e) {
				System.err.println("erro ao fechar resultSet: "+e);
			}
		}
		
		return clientes;
	}
	
	
	/**
	 * metodo para deletar um cliente
	 * @param id - recebe o id do cliente a ser removido
	 * @return true - se o cliente foi removido. false - se o cliente nao foi removido
	 */
	
	public boolean deleteCliente(int id) {

		PreparedStatement stmt = null;
		String sql = "delete from clientes where id_cliente = ?"; //string com sql a ser executada
		
		try {
			stmt = conDB.newPreparedStmt(sql); //criando um novo stmt para executar a sql com o parametro id
			stmt.setInt(1, id); //setando o valor no stmt
			stmt.executeUpdate(); // executando a query sql
			
			System.out.println("cliente deletado.");
			return true;
		
		}catch(SQLException e) {
			System.err.println("erro ao deletar: "+e);
			return false;
		}finally { //metodo para fechar as conexoes com o banco
			try {
				stmt.close();
				conDB.closeCon();
			
			}catch(SQLException e) {
				System.err.println("erro ao fechar conexoes: "+e);
			
			}
		}
	}
	
	
	public boolean updateCliente(int id) {
		Cliente c = Cliente.newCliente();
		
		ec.showMessage(c);
		
		PreparedStatement stmt= null;
		String sql = "update clientes set nome_cliente = ?, genero_cliente = ?, telefone_cliente = ?, "
				+ "dataNasc_cliente = ? where id_cliente = ?;";
		
		try {
			stmt= conDB.newPreparedStmt(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getGenero());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getDataNasc());
			stmt.setInt(5, id);
			
			stmt.executeUpdate();
			System.out.println("alterado com sucesso.");
			return true;
			
		}catch(SQLException e) {
			System.out.println("erro ao alterar cliente: "+e);
			return false;
		}finally {
			try {
				conDB.closeCon();
				stmt.close();
			}catch(SQLException e) {
				System.out.println("erro ao fechar conexoes: "+e);
			}
		}
	}
}
