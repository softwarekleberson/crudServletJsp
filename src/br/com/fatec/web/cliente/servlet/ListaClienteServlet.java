package br.com.fatec.web.cliente.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.ClienteDao;


@WebServlet("/listaCliente")
public class ListaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ClienteDao dao = new ClienteDao();
		try {
			request.setAttribute("cliente", dao.getClientes());
		} catch (Exception e) {
			System.out.println(e);
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/listaCliente.jsp");
		rd.forward(request, response);
		
	}

}
