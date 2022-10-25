package br.com.fatec.web.cliente.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCliente;


@WebServlet("/novoCliente")
public class NovoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomeCliente = req.getParameter("nome");
		String emailCliente = req.getParameter("email");
		String telefoneCliente = req.getParameter("telefone");
		
		Cliente cliente = new Cliente(nomeCliente, emailCliente, telefoneCliente);
		BancoCliente bancoCliente = new BancoCliente();
		bancoCliente.adiciona(cliente);
		
		//client server
		req.setAttribute("cliente", cliente.getNome());
		resp.sendRedirect("listaCliente");
		
		//chamar o jsp server side
		//RequestDispatcher rd = req.getRequestDispatcher("/listaCliente");
		//req.setAttribute("cliente", cliente.getNome());
		//rd.forward(req, resp);
		
	}
}
