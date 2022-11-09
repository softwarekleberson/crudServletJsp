package br.com.fatec.web.Produto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.ProdutoDao;


@WebServlet("/removeProduto")
public class RemoveProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Produto produto = new Produto();
		produto.setId(id);
		
		ProdutoDao dao = new ProdutoDao(produto);
		try {
			dao.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		response.sendRedirect("listaProduto");
	
	}

}
