package br.com.fatec.web.categoria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCategoria;


@WebServlet("/mostraCategoria")
public class MostraCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoCategoria bancoCategoria = new BancoCategoria();
		Categoria categoria = bancoCategoria.buscaPorId(id);
				
		request.setAttribute("categoria", categoria);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraCategoria.jsp");
		rd.forward(request, response);
		
	}

}
