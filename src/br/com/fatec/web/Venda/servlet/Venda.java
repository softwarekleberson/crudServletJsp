package br.com.fatec.web.Venda.servlet;

import java.math.BigDecimal;
import java.util.Date;

import br.com.fatec.web.EntidadeDominio.EntidadeDominio;
import br.com.fatec.web.Produto.servlet.Produto;
import br.com.fatec.web.cliente.servlet.Cliente;

public class Venda extends EntidadeDominio{

	private Date data;
	private Cliente cliente;
	private Produto produto;
	private Integer qtd;
	private BigDecimal desconto;
	private BigDecimal valorTotal;
	
	public Venda() {
	
	}
	
	public Venda(Date data, Integer qtd, BigDecimal desconto, BigDecimal valorTotal) {
		
		this.data = data;
		this.qtd = qtd;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
	}
	
	public Venda(Date data, Cliente cliente, Produto produto, Integer qtd, BigDecimal desconto, BigDecimal valorTotal) {
		
		this.data = data;
		this.cliente = cliente;
		this.produto = produto;
		this.qtd = qtd;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Integer getQtd() {
		return qtd;
	}
	
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	public BigDecimal getDesconto() {
		return desconto;
	}
	
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
