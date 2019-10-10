package br.com.fatec;

import java.io.ObjectInputStream.GetField;

import javax.naming.ConfigurationException;

public class Principal {

	public static void main(String[] args) {
//		Configuracao c = Configuracao.novaConfiguracao();
//		c.setValor("valor da configuracao c");
//		
//		Configuracao b = Configuracao.novaConfiguracao();
//		b.setValor("valor da configuracao b");
//		
//		Configuracao a = Configuracao.novaConfiguracao();
//		b.setValor("valor da configuracao a");
//		
//		System.out.println(c.getValor());
//		System.out.println(b.getValor());		
//		System.out.println(a .getValor());
		
		Pessoa p = new Pessoa()
				.iniciar()
				.comNome("paulao da zn")
				.comIade(20)
				.criar();
		
		System.out.println(p.getNome());
		System.out.println(p.getIdade());
		
		

	}

}
