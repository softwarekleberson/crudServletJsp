package br.com.fatec.web.BancoMemoria;

import br.com.fatec.web.Venda.servlet.Venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BancoVenda {

	private static List<Venda>lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		
		Date data = new Date();
		Venda v1 = new Venda(data, null, null, 10, 
							new BigDecimal("50"), new BigDecimal("1900"));
		v1.setId(chaveSequencial++);
		
		
		Venda v2 = new Venda(data, null, null, 10, 
							new BigDecimal("800"), new BigDecimal("3000"));
		v2.setId(chaveSequencial++);
		
		lista.add(v1);
		lista.add(v2);
		
	}
	
	
	public void adiciona(Venda venda) {
		venda.setId(chaveSequencial++);
		BancoVenda.lista.add(venda);
	}
	
	public List<Venda>getVendas(){
		return BancoVenda.lista;
	}

	public void remover(Integer id) {
		
		Iterator<Venda> it = lista.iterator();
		
		while(it.hasNext()) {
			Venda venda = it.next();
			
			if(venda.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Venda buscaPorId(Integer id) {
		for (Venda venda : lista) {
			if(venda.getId() == id) {
				return venda;
			}
		}
		return null;
	}

}
