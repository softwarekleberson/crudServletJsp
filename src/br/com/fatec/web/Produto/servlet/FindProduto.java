package br.com.fatec.web.Produto.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.ProdutoDao;


@WebServlet("/findProduto")
public class FindProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		ProdutoDao dao = new ProdutoDao();
		System.out.println(nome);
		
		try {
			request.setAttribute("produto", dao.findProduto(nome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/findListaProduto.jsp");
		rd.forward(request, response);
	}

}
