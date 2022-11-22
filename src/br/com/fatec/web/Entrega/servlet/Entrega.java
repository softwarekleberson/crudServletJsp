package br.com.fatec.web.Entrega.servlet;

import java.util.Date;

import br.com.fatec.web.EntidadeDominio.EntidadeDominio;
import br.com.fatec.web.Venda.servlet.Venda;

public class Entrega extends EntidadeDominio{

	private Venda venda;
	private Date data;
	
	public Entrega() {
		
	}
	
	public Entrega(Venda venda, Date data) {
		
		this.venda = venda;
		this.data = data;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
}
