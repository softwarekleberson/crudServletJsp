package br.com.fatec.web.categoria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;

@WebServlet("/mostraCategoria")
public class MostraCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("id"));
		Categoria cat = new Categoria();
		
		CategoriaDao dao = new CategoriaDao(cat);
		try {
			cat = dao.findByIdCategoria(codigo);
			
			request.setAttribute("categoria", cat);
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraCategoria.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
