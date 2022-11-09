package br.com.fatec.web.categoria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;

@WebServlet("/findCategoria")
public class FindCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		CategoriaDao dao = new CategoriaDao();
		System.out.println(nome);
		
		try {
			request.setAttribute("categoria", dao.findCategoria(nome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/findListaCategoria.jsp");
		rd.forward(request, response);
		
	}

}
