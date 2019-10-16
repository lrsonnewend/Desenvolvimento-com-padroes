package br.com.fatec;

public class Animais {
	private double peso;
	private String categoria;
	
	// Método para criar um novo objeto
	public static Animais getInstancia() {
		return new Animais();
	}
	
	// Constructor Privado
	private Animais() {
	}
	
	// Getters and Setters
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
