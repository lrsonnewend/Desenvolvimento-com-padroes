package com.external;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoa{
	
	
	@XmlElement(name = "numeroCartao")
	private String numeroCartao;
	@XmlElement(name = "nomeTitular")
	private String nomeTitular;
	@XmlElement(name = "nome")
	private String nome;
	@XmlElement(name = "CPF")
	private String CPF;
	@XmlElement(name = "bancoRecebimento")
	private String bancoRecebimento;
	@XmlElement(name = "bancoPagamento")
	private String bancoPagamento;
	
	@XmlElement(name = "parcelas")
	private int parcelas;
	@XmlElement(name = "valor")
	private double valor;
	@XmlElement(name = "data")
	private String data;	
	
	public Pessoa() {

	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return CPF;
	}
	public void setCpf(String CPF) {
		this.CPF = CPF;
	}
	public String getBancoRecebimento() {
		return bancoRecebimento;
	}
	public void setBancoRecebimento(String bancoRecebimento) {
		this.bancoRecebimento = bancoRecebimento;
	}
	public String getBancoPagamento() {
		return bancoPagamento;
	}
	public void setBancoPagamento(String bancoPagamento) {
		this.bancoPagamento = bancoPagamento;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
