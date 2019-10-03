package br.com.fatec;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

public interface TipoArquivo {
	public List<Pessoa> leTipo() throws IOException, JAXBException, FileNotFoundException;
}