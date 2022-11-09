package br.com.fatec.web.Entrega.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.web.Banco.EntregaDao;

@WebServlet("/novoEntrega")
public class NovoEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String data = request.getParameter("data");
		Entrega entrega = new Entrega();
		
		
		Date dataEntrega = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataEntrega = sdf.parse(data);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		EntregaDao dao = new EntregaDao();
		entrega.setData(dataEntrega);
		
		try {
			
			dao.newEntrega(entrega);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("entrega", entrega.getData());
		response.sendRedirect("listaEntrega");
					
	}

}
