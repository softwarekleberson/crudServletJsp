package br.com.fatec.web.Venda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.VendaDao;


@WebServlet("/removeVenda")
public class RemoveVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Venda ven = new Venda();
		ven.setId(id);
		
		VendaDao dao = new VendaDao(ven);
		try {
			dao.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("listaVenda");
		
	}

}
