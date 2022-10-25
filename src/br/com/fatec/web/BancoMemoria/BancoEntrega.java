package br.com.fatec.web.BancoMemoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fatec.web.Entrega.servlet.Entrega;

public class BancoEntrega {

	private static List<Entrega> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	public void adiciona(Entrega entrega) {
		entrega.setId(BancoEntrega.chaveSequencial++);
		BancoEntrega.lista.add(entrega);
	}
	
	public List<Entrega>getEntregas(){
		return BancoEntrega.lista;
	}

	public void remover(Integer id) {
		
		Iterator<Entrega> it = lista.iterator();
		
		while(it.hasNext()) {
			Entrega entrega = it.next();
			
			if(entrega.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Entrega buscaPorId(Integer id) {
		
		for (Entrega entrega : lista) {
			if(entrega.getId() == id) {
				return entrega;
			}
		}
		return null;
	}
}
