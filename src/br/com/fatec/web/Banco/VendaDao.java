package br.com.fatec.web.Banco;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fatec.web.Venda.servlet.Venda;

public class VendaDao extends BaseDao{

	public VendaDao() {
		
	}
	
	Venda ven = new Venda();
	
	public VendaDao(Venda ven) {
		this.ven = ven;
	}
	
	public Venda getVen() {
		return ven;
	}
	
	public void setVen(Venda ven) {
		this.ven = ven;
	}
	
	public void LoadVenda() {
		Date data = new Date();
		this.ven.setData(data);
		this.ven.setQtd(5);
		this.ven.setDesconto(new BigDecimal("100"));
		this.ven.setValorTotal(new BigDecimal("1000"));
	
	}
	
	public List<Venda> getVenda() throws Exception{
		List<Venda> lst = new ArrayList<Venda>();
		abrir();
		
		Statement s = getConn().createStatement();
		String sql = "select id, data, quantidade, desconto, valorTotal from venda";
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			Venda ven = new Venda();
			ven.setId(rs.getInt(1));
			ven.setData(rs.getDate(2));
			ven.setQtd(rs.getInt(3));
			ven.setDesconto(rs.getBigDecimal(4));
			ven.setValorTotal(rs.getBigDecimal(5));
			lst.add(ven);
		}
		
		s.close();
		rs.close();
		fechar();
		return lst;

	}
	
	public void newVenda(Venda venda) throws Exception {
		
		abrir();
		String query = "insert into venda(data, quantidade, desconto, valorTotal)" 
						+ " values(?,?,?,?)";
		
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		
		Date data = new Date();
		data = venda.getData();
		java.sql.Date sqldate = new java.sql.Date(data.getTime());
		
		preparedStatement.setDate(1, sqldate);
		preparedStatement.setInt(2, venda.getQtd());
		preparedStatement.setBigDecimal(3, venda.getDesconto());
		preparedStatement.setBigDecimal(4, venda.getValorTotal());
		preparedStatement.execute();
		fechar();
	}
	
	public void delete() throws Exception {
		abrir();
		String query = "delete from venda where id=?";
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setInt(1, ven.getId());
		preparedStatement.execute();
		fechar();
	}
	
	public ArrayList<Venda>findVenda(String qtd) throws Exception{
		
		super.abrir();
		ArrayList<Venda> lst = new ArrayList<>();
		String query = "SELECT id, data ,quantidade, desconto, valorTotal from venda where quantidade >= ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString (1, qtd);  
		ResultSet rs =   preparedStmt.executeQuery();
		
		while(rs.next()) {
			Venda venda = new Venda();
			venda.setId(Integer.parseInt(rs.getString(1)));
			venda.setData(rs.getDate(2));
			venda.setQtd(rs.getInt(3));
			venda.setDesconto(rs.getBigDecimal(4));
			venda.setValorTotal(rs.getBigDecimal(5));
			lst.add(venda);
			
		}
		
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}
	
	public Venda findByIdVenda(int id) throws Exception {
		super.abrir();
		
		String query = "select id, data, quantidade, desconto, valorTotal from venda where id=?";
		
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setInt(1, id);  
		ResultSet rs =   preparedStmt.executeQuery();
		
		Venda ven = new Venda();
		while(rs.next()) {
			ven.setId(Integer.parseInt(rs.getString(1)));
			ven.setData(rs.getDate(2));
			ven.setQtd(rs.getInt(3));
			ven.setDesconto(rs.getBigDecimal(4));
			ven.setValorTotal(rs.getBigDecimal(5));	
		}
		
		rs.close();
		return ven;
	}
	
	public void edit(Venda venda) throws Exception {
		abrir();
		
		String query = "update venda set data=?, quantidade=?, desconto=?, valorTotal=? where id=?";
	    PreparedStatement preparedStmt = getConn().prepareStatement(query);
	    
	    Date data = new Date();
		data = venda.getData();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, 1);
		data = cal.getTime();
		
		java.sql.Date sqldate = new java.sql.Date(data.getTime());
		
	    preparedStmt.setDate(1, sqldate);
	    preparedStmt.setInt(2, venda.getQtd());
	    preparedStmt.setBigDecimal(3, venda.getDesconto());
	    preparedStmt.setBigDecimal(4, venda.getValorTotal());
	    preparedStmt.setInt(5, venda.getId()); 
	    preparedStmt.execute();
	    fechar();
	}
	
}
