package com.external;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

public class Principal {
	public static void main(String[] args) throws HeadlessException, ParseException, FileNotFoundException, IOException, JAXBException {
		String caminhoArquivo = "C:\\Users\\Aluno\\Desktop\\listas\\lista 4 (JAXB)\\xml.xml";
		
		Xml xml =  new Xml(caminhoArquivo);
		Date dataAbertura = new Date(System.currentTimeMillis());
		Date dataTransacao; //data que fez transacao(aberto para digitacao)
		
		Conta conta = null;
		Transacao trans = null;
		
		System.out.println(xml.leArquivo(caminhoArquivo));
		
		for(Pessoa p: xml.leArquivo(caminhoArquivo)) {			
			conta = new Conta(dataAbertura, p.getBancoRecebimento(), "2441");
			dataTransacao = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(p.getData());
			
			
			trans = new Transacao(dataTransacao, conta, p.getValor());		
			//System.out.println(trans.FormatoRegiao(trans, 1));
			System.out.println(trans.CalculaDif(dataTransacao));
			//System.out.println(p.getData());

		}
	}
}
