package br.com.fatec;

public class Pessoa {
	private String nome;
	private int idade;
	private Pessoa alvo;

	public Pessoa iniciar() {
		alvo = new Pessoa();
		return this;
	}

	
	public Pessoa comNome(String nome) {
		alvo.nome = nome;
		return this;
	}
	
	public Pessoa comIade(int idade) {
		alvo.idade = idade;
		return this;
	}
	
	public Pessoa criar() {
		return alvo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public Pessoa getAlvo() {
		return alvo;
	}


	public void setAlvo(Pessoa alvo) {
		this.alvo = alvo;
	}
	
}

