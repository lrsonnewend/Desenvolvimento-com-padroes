package br.com.fatec;

import java.awt.Window.Type;
import java.io.*;
import java.util.*;

import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Main {
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void main(String[] args) throws IOException, JAXBException {

		String caminhoXml = "/home/lucas/Downloads/listas/lista 4 (JAXB)/json.json";
		TipoArquivo pessoaTipo;
		List<Pessoa> pagamentos = new ArrayList<>();
		Cpf validaCpf = new Cpf();
		
		if (caminhoXml.contains(".xml"))
			pessoaTipo = new Xml();
		else
			pessoaTipo = new Json();
			
			System.out.println(pessoaTipo.leTipo());
			
			for(Pessoa p: pessoaTipo.leTipo()) {
				if(!validaCpf.isValidCPF(p.getCpf())) {
					System.out.println("CPF: "+p.getCpf()+ " (inválido)");
				}
				else {
				System.out.println("CPF: "+p.getCpf());
				}
			}
	}
}
