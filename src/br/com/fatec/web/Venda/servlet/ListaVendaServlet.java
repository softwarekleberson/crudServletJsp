package br.com.fatec.web.Venda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import br.com.fatec.web.BancoMemoria.BancoVenda;

@WebServlet("/listaVenda")
public class ListaVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoVenda bancoVenda = new BancoVenda();
		List<Venda>lista = bancoVenda.getVendas();
		
		request.setAttribute("venda", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaVenda.jsp");
		rd.forward(request, response);
		
	}

}
