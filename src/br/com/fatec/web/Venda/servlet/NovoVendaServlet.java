package br.com.fatec.web.Venda.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.VendaDao;


@WebServlet("/novoVenda")
public class NovoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String quantidadeVenda = req.getParameter("qtd");
		String descontoVenda = req.getParameter("desconto");
		String valorVenda = req.getParameter("valor");
		
		Integer quantidade = Integer.valueOf(quantidadeVenda);
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
		
		Venda ven = new Venda();
		ven.setData(dataVenda);
		ven.setQtd(quantidade);
		ven.setDesconto(desconto);
		ven.setValorTotal(valor);
		
		VendaDao dao = new VendaDao();
		try {
			dao.newVenda(ven);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("venda", ven.getValorTotal());
		resp.sendRedirect("listaVenda");
		
	}

}
