package br.com.fatec.web.Produto.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.ProdutoDao;


@WebServlet("/alteraProduto")
public class AlteraProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		String precoProduto = request.getParameter("preco");
		BigDecimal preco = new BigDecimal(precoProduto);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Produto prod = new Produto(nomeProduto, descricaoProduto, preco);
		ProdutoDao dao = new ProdutoDao();
		
		try {
			
			if(paramId == null || paramId == "") {
				dao.newProduto(prod);
			}
			
			else {
				
				prod.setId(id);
				dao.edit(prod);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect("listaProduto");
		
	}

}
