package br.com.fatec.web.BancoMemoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fatec.web.cliente.servlet.Cliente;

public class BancoCliente {

	private static List<Cliente> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	
	static {
		
		Cliente jose = new Cliente("jose", "jose@gmail.com", "23785261");
		jose.setId(chaveSequencial++);
		
		Cliente carlos = new Cliente("carlos", "carlos@gmail.com", "85249063");
		carlos.setId(chaveSequencial++);
		
		lista.add(jose);
		lista.add(carlos);

	}
	
	public void adiciona(Cliente cliente) {
		cliente.setId(BancoCliente.chaveSequencial++);
		BancoCliente.lista.add(cliente);
	}
	
	
	public List<Cliente>getClientes(){
		return BancoCliente.lista;
	}

	
	public void remover(Integer id) {
		
		Iterator<Cliente> it = lista.iterator();
		
		while(it.hasNext()) {
			Cliente cliente = it.next();
			
			if(cliente.getId() == id) {
				it.remove();
			}
		}
		
	}


	public Cliente buscaPorId(Integer id) {
		
		for (Cliente cliente : lista) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		
		return null;
	}

}
