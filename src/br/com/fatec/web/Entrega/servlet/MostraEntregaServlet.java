package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoEntrega;


@WebServlet("/mostraEntrega")
public class MostraEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoEntrega bancoEntrega = new BancoEntrega();
		Entrega entrega = bancoEntrega.buscaPorId(id);
				
		request.setAttribute("entrega", entrega);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEntrega.jsp");
		rd.forward(request, response);
	}

}
