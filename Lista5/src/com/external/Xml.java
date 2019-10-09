package com.external;

import java.io.*;
import java.util.*;

import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class Xml{
	
	public Xml(String caminhoArquivo) {
		
	}

	public List<Pessoa> leArquivo(String caminhoArquivo) throws JAXBException, FileNotFoundException {

		JAXBContext jaxbContext = JAXBContext.newInstance(PessoaList.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		InputStream stream = new FileInputStream(new File(caminhoArquivo));

		PessoaList people = (PessoaList) unmarshaller.unmarshal(stream);
		List<Pessoa> pessoas2 = new ArrayList<Pessoa>();

		pessoas2.addAll(people.getList());

		return pessoas2;

	}
	
}