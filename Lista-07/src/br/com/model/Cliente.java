package br.com.model;

import java.text.Collator;
import java.util.Date;
import java.util.Locale;

public class Cliente implements Comparable<Cliente>{

	private int idCliente;
	private String nome, telefone, genero;
	private String dataNasc;

	private Cliente() {

	}

	public static Cliente newCliente() {
		return new Cliente();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	



	@Override
	public int compareTo(Cliente c) {
		Collator col = Collator.getInstance(new Locale("pt", "BR"));
		if(c != null)
			return col.compare(this.getNome(), c.getNome());	
		
		else
			return 0;
	}
}
