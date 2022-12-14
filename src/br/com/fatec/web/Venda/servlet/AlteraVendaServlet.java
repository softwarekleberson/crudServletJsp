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


@WebServlet("/alteraVenda")
public class AlteraVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String quantidadeVenda = request.getParameter("qtd");
		String descontoVenda = request.getParameter("desconto");
		String valorVenda = request.getParameter("valor");
		
		Integer qtd = Integer.valueOf(quantidadeVenda);
		BigDecimal desconto = new BigDecimal(descontoVenda);
		BigDecimal valor = new BigDecimal(valorVenda);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String data = request.getParameter("data");
		
		Date dataVenda = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataVenda = sdf.parse(data);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Venda venda = new Venda(dataVenda, qtd, desconto, valor);
		VendaDao dao = new VendaDao();
		
		try {
			
			if(paramId == null || paramId == "") {
				dao.newVenda(venda);
			}
			else {
				
				venda.setId(id);
				dao.edit(venda);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("listaVenda");
		
	}

}
