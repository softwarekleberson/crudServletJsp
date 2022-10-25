package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.BancoMemoria.BancoEntrega;

@WebServlet("/novoEntrega")
public class NovoEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String data = request.getParameter("data");
		
		Date dataEntrega = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataEntrega = sdf.parse(data);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		BancoEntrega bancoEntrega = new BancoEntrega();
		
		Entrega entrega = new Entrega(null, dataEntrega);
		bancoEntrega.adiciona(entrega);
		
		request.setAttribute("entrega", entrega.getData());
		response.sendRedirect("listaEntrega");
		
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEntrega");
		//request.setAttribute("entrega", entrega.getData());
		//rd.forward(request, response);
		
				
	}

}
