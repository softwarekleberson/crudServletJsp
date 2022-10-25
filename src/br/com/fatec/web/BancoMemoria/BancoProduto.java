package br.com.fatec.web.BancoMemoria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fatec.web.Produto.servlet.Produto;

public class BancoProduto {

	private static List<Produto> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		
		Produto p1 = new Produto("ps5", "200 gb", null, new BigDecimal("5000"));
		p1.setId(chaveSequencial++);
		
		Produto p2 = new Produto("celular", "xiome", null, new BigDecimal("2500"));
		p2.setId(chaveSequencial++);
		
		lista.add(p1);
		lista.add(p2);
	}
	
	public void adiciona(Produto produto) {
		produto.setId(BancoProduto.chaveSequencial++);
		BancoProduto.lista.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return BancoProduto.lista;
	}

	public void remover(Integer id) {
		
		Iterator<Produto> it = lista.iterator();
		
		while(it.hasNext()) {
			Produto produto = it.next();
			
			if(produto.getId() == id) {
				it.remove();
			}
		}
		
	}

	public static Produto buscaPorId(Integer id) {
		
		for (Produto produto : lista) {
			if(produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

}
