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


@WebServlet("/alteraEntrega")
public class AlteraEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataEntrega = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataEntrega = sdf.parse(data);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Entrega entrega = new Entrega();
		entrega.setData(dataEntrega);
		
		EntregaDao entregaDao = new EntregaDao();
		
		try {
			
			if(paramId == null || paramId == "") {
				entregaDao.newEntrega(entrega);
			}
			else {
				entrega.setId(id);
				entregaDao.editar(entrega);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		response.sendRedirect("listaEntrega");
				
	}

}
