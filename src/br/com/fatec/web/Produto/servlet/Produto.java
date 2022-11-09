package br.com.fatec.web.Produto.servlet;

import java.math.BigDecimal;

import br.com.fatec.web.EntidadeDominio.EntidadeDominio;
import br.com.fatec.web.categoria.servlet.*;

public class Produto extends EntidadeDominio{

	private String nome;
	private String descricao;
	private Categoria categoria;
	private BigDecimal preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String descricao, Categoria categoria, BigDecimal preco) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.preco = preco;
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
}
