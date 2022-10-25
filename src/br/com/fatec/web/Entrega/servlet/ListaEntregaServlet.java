package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoEntrega;

@WebServlet("/listaEntrega")
public class ListaEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BancoEntrega bancoEntrega = new BancoEntrega();
		List<Entrega> lista = bancoEntrega.getEntregas();
		request.setAttribute("entrega", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEntrega.jsp");
		rd.forward(request, response);
		
	}

}
