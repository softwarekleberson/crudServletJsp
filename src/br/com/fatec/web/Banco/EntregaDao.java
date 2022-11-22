package br.com.fatec.web.Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fatec.web.Entrega.servlet.Entrega;

public class EntregaDao extends BaseDao{

	public EntregaDao() {

	}
	
	Entrega ent;
	
	public EntregaDao(Entrega ent) {
		this.ent = ent;
	}
	
	public Entrega getEnt() {
		return ent;
	}
	
	public void setEnt(Entrega ent) {
		this.ent = ent;
	}
	
	public void LoadEntrega() {
		Date data = new Date();
		this.ent.setData(data);
	}
	
	public List<Entrega> getEntregas() throws Exception{
		List<Entrega> lst = new ArrayList<Entrega>();
		abrir();
		
		Statement s = getConn().createStatement();
		String sql = "select id, data from entrega";
		ResultSet rs = s.executeQuery(sql);
		
		
		while(rs.next()) {
			Entrega entrega = new Entrega();
			entrega.setId(rs.getInt(1));
			entrega.setData(rs.getDate(2));
			lst.add(entrega);
		}
		
		s.close();
		rs.close();
		fechar();

		return lst;
	}
	
	public void newEntrega(Entrega entrega) throws Exception {
		abrir();
		String query = "insert into entrega(data)"
						+ "values(?)";
		
		Date data = new Date(); 
		data = entrega.getData();
		java.sql.Date sqldate = new java.sql.Date(data.getTime());
		
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setDate(1, sqldate);
		preparedStatement.execute();
		fechar();
	}
	
	public void delete() throws Exception {
		abrir();
		String query = "delete from entrega where id=?";
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setInt(1, ent.getId());
		preparedStatement.execute();
		fechar();
	}
	
	public List<Entrega>findEntrega(String data) throws Exception {
		
		super.abrir();
		ArrayList<Entrega> lst = new ArrayList<>();
		
		String query = "select id, data from entrega where data like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString (1, data +'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		
		while(rs.next()) {
			Entrega entrega = new Entrega();
			entrega.setId(Integer.parseInt(rs.getString(1)));
			entrega.setData(rs.getDate(2));
			lst.add(entrega);
		}
		
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
		
	} 
	
	public Entrega findById(int id) throws Exception {
		
		super.abrir();
		
		String sql = "SELECT id, data FROM ENTREGA where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setInt(1, id);  
		
		ResultSet rs =   preparedStmt.executeQuery();
		Entrega entrega = new Entrega();
		
		while(rs.next()) {
			entrega.setId(Integer.parseInt(rs.getString(1)));
			entrega.setData(rs.getDate(2));
		}
		
		rs.close();
		return entrega;
		
	}
	
	public void editar(Entrega entrega) throws Exception {
		abrir();
		
		String query = "update entrega set data=? where id=?";
	    PreparedStatement preparedStmt = getConn().prepareStatement(query);
	    
	    Date data = new Date();
		data = entrega.getData();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, 1);
		data = cal.getTime();
		
		java.sql.Date sqldate = new java.sql.Date(data.getTime());
		
		preparedStmt.setDate(1, sqldate);
		preparedStmt.setInt(2, entrega.getId());
		preparedStmt.execute();
		
		fechar();
	}
}
