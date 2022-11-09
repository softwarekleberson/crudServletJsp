package br.com.fatec.web.Venda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.VendaDao;


@WebServlet("/findVenda")
public class FindVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qtd = request.getParameter("qtd");
		VendaDao dao = new VendaDao();
		System.out.println(qtd);
		
		try {
			request.setAttribute("venda", dao.findVenda(qtd));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/findListaVenda.jsp");
		rd.forward(request, response);
		
	}

}
