package br.com.fatec.web.Venda.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoVenda;


@WebServlet("/novoVenda")
public class NovoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String quantidadeVenda = req.getParameter("qtd");
		String descontoVenda = req.getParameter("desconto");
		String valorVenda = req.getParameter("valor");
		
		BigDecimal desconto = new BigDecimal(descontoVenda);
		BigDecimal valor = new BigDecimal(valorVenda);
		
		String data = req.getParameter("data");
		
		Date dataVenda = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataVenda = sdf.parse(data);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Venda venda = new Venda(dataVenda, null, null, null, desconto, valor);
		BancoVenda bancoVenda = new BancoVenda();
		bancoVenda.adiciona(venda);
		
		req.setAttribute("venda", venda.getValorTotal());
		resp.sendRedirect("listaVenda");
		
		//RequestDispatcher rd = req.getRequestDispatcher("/listaVenda");
		//req.setAttribute("venda", venda.getValorTotal());
		//rd.forward(req, resp);
		
	}

}
