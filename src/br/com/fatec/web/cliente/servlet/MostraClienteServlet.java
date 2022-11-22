package br.com.fatec.web.cliente.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fatec.web.Banco.ClienteDao;


@WebServlet("/mostraCliente")
public class MostraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao(cliente);
		
		try {
			
			cliente = dao.findByIdCliente(id);
			
			request.setAttribute("cliente", cliente);
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraCliente.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
