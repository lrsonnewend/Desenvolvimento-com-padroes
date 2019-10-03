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

public class Xml implements TipoArquivo {

	@Override
	public List<Pessoa> leTipo() throws JAXBException, FileNotFoundException {
		String caminhoXml = "/home/lucas/Downloads/listas/lista 4 (JAXB)/xml.xml";

		JAXBContext jaxbContext = JAXBContext.newInstance(PessoaList.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		InputStream stream = new FileInputStream(new File(caminhoXml));

		PessoaList people = (PessoaList) unmarshaller.unmarshal(stream);
		List<Pessoa> pessoas2 = new ArrayList<Pessoa>();

		pessoas2.addAll(people.getList());

		return pessoas2;

	}
	
}