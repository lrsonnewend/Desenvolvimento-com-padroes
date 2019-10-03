package br.com.fatec;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "list")
public class PessoaList {
	
	@XmlElements({
		@XmlElement(name = "br.com.pageseguro.RemessaBoleto", type = Pessoa.class),
		@XmlElement(name = "br.com.pageseguro.RemessaCartaoDebito", type = Pessoa.class),
		@XmlElement(name = "br.com.pageseguro.RemessaCartaoCredito", type = Pessoa.class)
	})
	private ArrayList<Pessoa> lista = new ArrayList<>();

	public ArrayList<Pessoa> getList() {
		return lista;
	}
	
	public void setList(ArrayList<Pessoa> listas) {
		this.lista = listas;
	}

	public PessoaList() {
		
	}

	
}