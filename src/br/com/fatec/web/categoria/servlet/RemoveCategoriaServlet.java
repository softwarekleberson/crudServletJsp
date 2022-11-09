package br.com.fatec.web.categoria.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;


@WebServlet("/removeCategoria")
public class RemoveCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Categoria vo = new Categoria();
		
		vo.setId(id);
		CategoriaDao dao = new CategoriaDao(vo);
		
		try {
			dao.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		response.sendRedirect("listaCategoria");
	}

}
