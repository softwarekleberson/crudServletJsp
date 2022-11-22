package br.com.fatec.web.Venda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.VendaDao;


@WebServlet("/mostraVenda")
public class MostraVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Venda venda = new Venda();
		VendaDao dao = new VendaDao(venda);
		
		try {
			
			venda = dao.findByIdVenda(id);
			System.out.println(id);
			
			request.setAttribute("venda", venda);
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraVenda.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
