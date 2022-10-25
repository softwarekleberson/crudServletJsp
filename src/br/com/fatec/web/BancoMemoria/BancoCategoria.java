package br.com.fatec.web.BancoMemoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fatec.web.categoria.servlet.Categoria;

public class BancoCategoria {

	private static List<Categoria> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		
		Categoria acer = new Categoria("notbooc acer", "acer aspire 5 nitro");
		acer.setId(chaveSequencial++);
		
		Categoria apple = new Categoria("apple notbock", "notbock 20 giba ram");
		apple.setId(chaveSequencial++);
		
		lista.add(acer);
		lista.add(apple);
	}
	
	public void adiciona(Categoria categoria) {
		categoria.setId(BancoCategoria.chaveSequencial++);
		BancoCategoria.lista.add(categoria);
	}
	
	public List<Categoria>getCategorias(){
		return BancoCategoria.lista;
	}

	public void remover(Integer id) {
		
		Iterator<Categoria> it = lista.iterator();
		
		while(it.hasNext()) {
			Categoria categoria = it.next();
			
			if(categoria.getId() == id) {
				it.remove();
			}
		}
	}

	public Categoria buscaPorId(Integer id) {
		for (Categoria categoria : lista) {
			if(categoria.getId() == id) {
				return categoria;
			}
		}
		return null;
	}
	
	
}
