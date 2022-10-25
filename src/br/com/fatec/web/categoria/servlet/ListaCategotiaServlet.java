package br.com.fatec.web.categoria.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoCategoria;


@WebServlet("/listaCategoria")
public class ListaCategotiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoCategoria bancoCategoria = new BancoCategoria();
		List<Categoria> lista = bancoCategoria.getCategorias();
		
		request.setAttribute("categoria", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaCategoria.jsp");
		rd.forward(request, response);
	}

}
