package br.com.fatec.web.categoria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;


@WebServlet("/listaCategoria")
public class ListaCategotiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDao dao = new CategoriaDao();
		try {
			request.setAttribute("categoria", dao.getCategoria());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaCategoria.jsp");
		rd.forward(request, response);
	}

}
