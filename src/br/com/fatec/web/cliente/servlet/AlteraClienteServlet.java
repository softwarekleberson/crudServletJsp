package br.com.fatec.web.cliente.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		BancoCliente bancoCliente = new BancoCliente();
		Cliente cliente = bancoCliente.buscaPorId(id);
		
		cliente.setNome(nomeCliente);
		cliente.setEmail(emailCliente);
		cliente.setTelefone(telefoneCliente);
		
		response.sendRedirect("listaCliente");
	}

}
