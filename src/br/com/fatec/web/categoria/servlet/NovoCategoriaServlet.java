package br.com.fatec.web.categoria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;


@WebServlet("/novoCategoria")
public class NovoCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeCategoria = request.getParameter("nome");
		String descricaoCategoria = request.getParameter("descricao");
		
		Categoria categoria = new Categoria(nomeCategoria, descricaoCategoria);
		CategoriaDao categoriaDao = new CategoriaDao();
		
		try {
			categoriaDao.newProduto(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("categoria", categoria);
		response.sendRedirect("listaCategoria");
		
	}

}
