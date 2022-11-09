package br.com.fatec.web.Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.web.categoria.servlet.Categoria;

public class CategoriaDao extends BaseDao {
	
	
	public CategoriaDao() {

	}
	
	Categoria cat;
	
	public CategoriaDao(Categoria cat) {
		this.cat = cat;
	}
	
	public Categoria getCat() {
		return cat;
	}
	
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	public void LoadProduct() {
		this.cat.setNome("Nome Teste");	
		this.cat.setDescricao("Descricao Teste");
	}
	
	public List<Categoria>getCategoria() throws Exception{
		
		List<Categoria> cat = new ArrayList<Categoria>();
		abrir();
		System.out.println("lista");
		
		Statement s = getConn().createStatement();
		String sql = "select id, nome, descricao" + " from categoria";
		
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt(1));
			
			categoria.setNome(rs.getString(2));
			
			categoria.setDescricao(rs.getString(3));
			cat.add(categoria);
		}
		
		s.close();
		rs.close();
		fechar();
		return cat;
		
	}
	
	public void newCategoria(Categoria categoria) throws Exception {
		
		abrir();
		String query = "insert into Categoria "
				+ "(nome, descricao)" + "values(?,?)";
		
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setString(1, categoria.getNome());
		preparedStatement.setString(2, categoria.getDescricao());
		preparedStatement.execute();
		fechar();
		
	}
	
	public void delete() throws Exception {
		
		abrir();
		String query = "delete from categoria where id=?";
		
		PreparedStatement preparedStatement = 
						  getConn().prepareStatement(query);
		
		preparedStatement.setInt(1, cat.getId());
		preparedStatement.execute();
		fechar();
	}
	
	public ArrayList<Categoria> findCategoria(String nome) throws Exception{
		
		super.abrir();
		ArrayList<Categoria> lst = new ArrayList<>();
		System.out.println(nome);
		
		String sql = "select id, nome, descricao from categoria where nome like ?";
		PreparedStatement preparedStatement = getConn().prepareStatement(sql);
		preparedStatement.setString(1, nome + '%');
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(Integer.parseInt(rs.getString(1)));
			categoria.setNome(rs.getString(2));
			categoria.setDescricao(rs.getString(3));
			lst.add(categoria);
		}
		
		preparedStatement.close();
		rs.close();
		fechar();
		return lst;
	}
	
	public Categoria findByIdCategoria(Integer id) throws Exception {
		super.abrir();
		
		String query = "select id, nome, descricao from categoria where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setInt(1, id);  
		  
		ResultSet rs =   preparedStmt.executeQuery();
		Categoria cat = new Categoria();
		
		while(rs.next()) {
			cat.setId(Integer.parseInt(rs.getString(1)));
			cat.setNome(rs.getString(2));
			cat.setDescricao(rs.getString(3));
		}
		
		rs.close();
		System.out.println("find");
		return cat;	
	}
	
	public void editar(Categoria cat) throws Exception {
		abrir();
		
		String query = "update categoria set nome=?, descricao=? where id=?";
	    PreparedStatement preparedStmt = getConn().prepareStatement(query);
	    
	    preparedStmt.setString(1, cat.getNome());
	    preparedStmt.setString(2, cat.getDescricao());
	    preparedStmt.setInt(3, cat.getId());
	    preparedStmt.execute();
	    fechar();

	}
	
}
