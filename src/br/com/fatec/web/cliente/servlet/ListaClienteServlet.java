package br.com.fatec.web.cliente.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCliente;


@WebServlet("/listaCliente")
public class ListaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoCliente bancoCliente = new BancoCliente();
		List<Cliente> lista = bancoCliente.getClientes();
		request.setAttribute("cliente", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaCliente.jsp");
		rd.forward(request, response);
		
	}

}
