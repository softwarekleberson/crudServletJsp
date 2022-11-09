package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.EntregaDao;


@WebServlet("/removeEntrega")
public class RemoveEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Entrega entrega = new Entrega();
		entrega.setId(id);
		
		EntregaDao dao = new EntregaDao(entrega);
		try {
			dao.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("listaEntrega");
	
	}

}
