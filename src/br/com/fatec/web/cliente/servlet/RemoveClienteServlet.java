package br.com.fatec.web.cliente.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCliente;


@WebServlet("/removeCliente")
public class RemoveClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");		
		Integer id = Integer.valueOf(paramId);
		
		BancoCliente bancoCliente = new BancoCliente();
		bancoCliente.remover(id);
		
		response.sendRedirect("listaCliente");
		
	}

}
