package br.com.fatec.web.Banco;

import java.util.List;

import br.com.fatec.web.EntidadeDominio.EntidadeDominio;

public interface Icrud {

	public void adiciona(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	
}
