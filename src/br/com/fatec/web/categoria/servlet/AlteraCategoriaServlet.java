package br.com.fatec.web.categoria.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.CategoriaDao;
import br.com.fatec.web.BancoMemoria.BancoCategoria;


@WebServlet("/alteraCategoria")
public class AlteraCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeCategoria = request.getParameter("nome");
		String descricaoCategoria = request.getParameter("descricao");
		String paramId = request.getParameter("id");
				
		Categoria categoria = new Categoria(nomeCategoria, descricaoCategoria);
		
		CategoriaDao dao = new CategoriaDao();
		try {
			
			if(paramId == "" || paramId == null) {
				dao.newCategoria(categoria);
			}
			
			else {		
				categoria.setId(Integer.parseInt(paramId));
				dao.editar(categoria);
			}
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	
		response.sendRedirect("listaCategoria");
	}

}
