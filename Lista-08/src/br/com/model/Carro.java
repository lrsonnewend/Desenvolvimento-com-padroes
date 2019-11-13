package br.com.model;


/**
 * @author Gabriel Carvalho, Lucas Ribeiro, Paulo Henrique
 */
public class Carro {
	
	private int id_carro;
	private String numeroPlaca, modelo, anoFabricacao;
	private double valorCompra;
	

	private Carro() {
		
	}
	
	public static Carro newServico() {
		return new Carro();
	}

	public int getId_carro() {
		return id_carro;
	}

	public void setId_carro(int id_carro) {
		this.id_carro = id_carro;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	
}
