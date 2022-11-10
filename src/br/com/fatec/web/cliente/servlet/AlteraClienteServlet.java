package br.com.fatec.web.cliente.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.ClienteDao;
import br.com.fatec.web.BancoMemoria.BancoCliente;


@WebServlet("/alteraCliente")
public class AlteraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nomeCliente = request.getParameter("nome");
		String emailCliente = request.getParameter("email");
		String telefoneCliente = request.getParameter("telefone");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Cliente cli = new Cliente(nomeCliente, emailCliente, telefoneCliente);
		ClienteDao dao = new ClienteDao();
		
		try {
			
			if(paramId == null || paramId =="") {
				dao.newCliente(cli);
			}
			
			else {
				
				cli.setId(id);
				dao.edit(cli);
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	
		response.sendRedirect("listaCliente");
	}
}
