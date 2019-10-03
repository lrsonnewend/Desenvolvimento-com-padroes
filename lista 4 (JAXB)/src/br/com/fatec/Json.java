package br.com.fatec;

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


public class Json implements TipoArquivo {
	
	@Override
	public List<Pessoa> leTipo() throws IOException {
		Gson gson = new Gson();
		List<Pessoa> pessoas = new ArrayList<>();

		String caminho = "/home/lucas/Downloads/listas/lista 4 (JAXB)/json.json";
		BufferedReader leitor = new BufferedReader(new FileReader(caminho));
		
		String linha = leitor.readLine();
		String json = "";
		int pos = 0;
		
		while (linha != null) {
			json = json + linha;
			linha = leitor.readLine();
		}
		leitor.close();

		Gson g = new Gson();

		java.lang.reflect.Type type = new TypeToken<List<Pessoa>>() {}.getType();
		pessoas = g.fromJson(json, type);
		Pessoa[] pessoas2 = new Pessoa[200];

		for (Pessoa p : pessoas) {
			System.out.println(p.getNome());
		}
		
		return pessoas;
			
		}

	}


