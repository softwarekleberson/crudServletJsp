package br.com.fatec.web.categoria.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCategoria;


@WebServlet("/removeCategoria")
public class RemoveCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");		
		Integer id = Integer.valueOf(paramId);
				
		BancoCategoria bancoCategoria = new BancoCategoria();
		bancoCategoria.remover(id);
		
		response.sendRedirect("listaCategoria");
	}

}
