package com.external;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.fatec.TransacaoInfo;
import br.com.fatec.TransacaoInfoBrasil;


public class Transacao {
	private Date data;
	private Conta conta;
	private double valor;

	public Transacao(Date data, Conta conta, double valor) {
		this.data = data;
		this.conta = conta;
		this.valor = valor;
	}

	public Date getData() {
		return data;		
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public double getValor() {
		return valor;
	}
	
	// 2018-09-02 02:58:10.96 UTC
	public String FormatoRegiao(Transacao trans, int Regiao) {
		String dataFormatada = "";
		TransacaoInfo ti = null;
		if(Regiao == 1) {
			ti = new TransacaoInfoBrasil(trans);
		}
		else {
			SimpleDateFormat mascara = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dataFormatada =  mascara.format(trans.getData());
			
		}		
		if (dataFormatada=="")
			dataFormatada = ti.dataPorRegiao();
		return dataFormatada;
	}
	
	
	
	public String CalculaDif(Date dataTransacao) {
		Date dataAtual = new Date(System.currentTimeMillis());	
		long diff = 0;
		long saida = 0;
		
		if (dataAtual.getTime() >= dataTransacao.getTime()) {
			diff = dataAtual.getTime() - dataTransacao.getTime();
		}		
		else{
			diff = dataTransacao.getTime() - dataAtual.getTime();
		}
		
		long diffSeconds = diff/ 1000 % 60;
		long diffMinutes = diff/ (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		saida = diffSeconds;
		if (diffSeconds > 59)
			saida = diffMinutes;
		
		else if (diffMinutes > 59)
			saida = diffHours;
		
		else if (diffHours > 23) 
			saida = diffDays;
		
		
		return ("Dias: " + diffDays + ", Horas: " + diffHours + ", Minutos: " + diffMinutes + ", Segundos: " + diffSeconds);
//		return ("Saida: "+saida);
		
	}
	
	
	
}