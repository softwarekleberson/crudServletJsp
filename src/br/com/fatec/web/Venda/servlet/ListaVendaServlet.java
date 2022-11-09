package br.com.fatec.web.Venda.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.fatec.web.Banco.VendaDao;

@WebServlet("/listaVenda")
public class ListaVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VendaDao dao = new VendaDao();
			try {
				request.setAttribute("venda", dao.getVenda());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaVenda.jsp");
		rd.forward(request, response);
		
	}

}
