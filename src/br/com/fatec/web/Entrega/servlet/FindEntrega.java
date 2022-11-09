package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.EntregaDao;

@WebServlet("/findEntrega")
public class FindEntrega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data");
		EntregaDao dao = new EntregaDao();
		
		try {
			request.setAttribute("entrega", dao.findEntrega(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/findListaEntrega.jsp");
		rd.forward(request, response);
	}

}
