package br.com.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionSqlite.ConnectionDB;

public class RelatorioDAO {
	ConnectionDB conDB = new ConnectionDB();
	
	
	public RelatorioDAO() {
		conDB.connection();
	}

	
	public void servicoMaisProcurado(int opcao){
		String sql = null;
		
		//servico mais procurado		
		sql = lidaServMaisProcurado(opcao);
		
		ResultSet rs = null; //recebe os resultados da busca no bd
		Statement stmt = null; //executa a string sql 
		stmt = conDB.newStatement();
		
		try{	
			
			rs = stmt.executeQuery(sql); //atribuindo os valores da consulta 
		
			while(rs.next()) {				
				System.out.println("Servico: ("+ rs.getInt("id_servico") + "): " + rs.getString("nome_servico")+"\n");								
			}
			
		}catch(SQLException e) {
			System.err.println("erro ao listar todos o servico mais procurado: "+e);
			
		}finally { //metodo para fechar as conexoes com o bd 
			try {
				stmt.close();
				rs.close();
				conDB.closeCon();
				
			}catch(SQLException e) {
				System.err.println("erro ao fechar resultSet: "+e);
			}
		}	
	}
	
	
	public String lidaServMaisProcurado(int op) {
		String sql = null;
		if (op == 1) {
			sql = "select cs.id_servico,"
					+ " s.nome_servico,"
					+ " count(cs.id_servico) as qtd_servico "
					+ "from cliente_servico cs LEFT JOIN servicos s on s.id_servico = cs.id_servico "
					+ "group by cs.id_servico "
					+ "order by count(cs.id_servico) DESC LIMIT 1;"; //string para ser executada no banco de dados
		}
		
		else if(op == 2) {
			sql = "select cs.id_servico,s.nome_servico, count(cs.id_servico) as qtd_servico from cliente_servico cs\n" + 
					"    LEFT JOIN servicos s on s.id_servico = cs.id_servico\n" + 
					"    LEFT JOIN clientes c on c.id_cliente = cs.id_cliente\n" + 
					"   	where c.genero_cliente = 'M' group by cs.id_servico\n" + 
					"   	order by count(cs.id_servico) DESC LIMIT 1;";
		}
		
		else if(op == 3) {
			sql = "select cs.id_servico,s.nome_servico, count(cs.id_servico) as qtd_servico from cliente_servico cs\n" + 
					"    LEFT JOIN servicos s on s.id_servico = cs.id_servico\n" + 
					"    LEFT JOIN clientes c on c.id_cliente = cs.id_cliente\n" + 
					"   	where c.genero_cliente = 'F' group by cs.id_servico\n" + 
					"   	order by count(cs.id_servico) DESC LIMIT 1;";
		}		
		return sql;
	}
}
