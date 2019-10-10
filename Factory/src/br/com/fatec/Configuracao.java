package br.com.fatec;

public class Configuracao {
	private String valor;
	private static Configuracao cfg;
	
	public static Configuracao novaConfiguracao() {
		if(cfg == null) {
			cfg = new Configuracao();		
		}
		return cfg;
	}
	
	private Configuracao() {
		
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
