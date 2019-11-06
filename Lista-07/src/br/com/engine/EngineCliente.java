package br.com.engine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import  br.com.fatec.*;

public class EngineCliente {
	int c = 0;
	List<Cliente> clientes = new ArrayList<>();
	Cliente cliente = Cliente.newCliente();

	public List<Cliente> create () throws ParseException{
		Date date;
		String dataNascimento;
		c+=1;
		
		cliente.setGenero(JOptionPane.showInputDialog("Genero: "));
		cliente.setNome(JOptionPane.showInputDialog("Nome: "));
		dataNascimento = JOptionPane.showInputDialog("Data de nascimento: ");
		date = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimento);
		cliente.setDataNasc(date);
		cliente.setTelefone(JOptionPane.showInputDialog("Telefone: "));
		cliente.setIdCliente(c);
		
		clientes.add(cliente);
		return clientes;		
	}
	
	public void remove (List<Cliente> clientes) {
		int  id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do cliente que deseja remover: "));
        
        for (Cliente c: clientes){
            if(c.getIdCliente() == id){
                clientes.remove(c.getIdCliente());
                JOptionPane.showMessageDialog(null, "Cliente excluído."); 
                break;
            }                
        } 
    }
	
	public void read(List<Cliente> clientes) {
		//Collections.sort(clientes);
		
		for(Cliente c: clientes) {
			JOptionPane.showMessageDialog(null, c.getNome());
		}
	}
}
