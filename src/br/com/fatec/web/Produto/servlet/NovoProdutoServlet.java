package br.com.fatec.web.Produto.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoProduto;


@WebServlet("/novoProduto")
public class NovoProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomeProduto = req.getParameter("nome");
		String descricaoProduto = req.getParameter("descricao");
		String precoProduto = req.getParameter("preco");
		BigDecimal preco = new BigDecimal(precoProduto);
		
		Produto produto = new Produto(nomeProduto, descricaoProduto, null, preco);
		BancoProduto bancoProduto = new BancoProduto();
		bancoProduto.adiciona(produto);
		
		req.setAttribute("produto", produto.getNome());
		resp.sendRedirect("listaProduto");
		
		//RequestDispatcher rd = req.getRequestDispatcher("/listaProduto");
		//req.setAttribute("produto", produto.getNome());
		//rd.forward(req, resp);

	}

}
