package br.com.fatec.web.categoria.servlet;

import br.com.fatec.web.EntidadeDominio.EntidadeDominio;

public class Categoria extends EntidadeDominio{

	private String nome;
	private String descricao;
	
	public Categoria(String nome, String descricao) {
		
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
