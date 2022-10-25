package br.com.fatec.web.Produto.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoProduto;


@WebServlet("/listaProduto")
public class ListaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoProduto bancoProduto = new BancoProduto();
		List<Produto>lista = bancoProduto.getProdutos();
		request.setAttribute("produto", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaProduto.jsp");
		rd.forward(request, response);
	}

}
