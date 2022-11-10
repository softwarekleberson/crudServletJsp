package br.com.fatec.web.Banco;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.web.Produto.servlet.Produto;

public class ProdutoDao extends BaseDao{

	public ProdutoDao() {
	
	}
	
	Produto vo;
	
	public ProdutoDao(Produto vo) {
		this.vo=vo;
	}
	
	public Produto getVo() {
		return vo;
	}

	public void setVo(Produto vo) {
		this.vo = vo;
	}

	public void LoadProduct() {
		this.vo.setDescricao("Descricao Teste");
		this.vo.setNome("Nome Teste");	
		this.vo.setPreco(new BigDecimal("1000"));	
	}
	
	public List<Produto> getProducts() throws Exception {	
		List<Produto> lst = new ArrayList<Produto>();
		abrir();
		Statement s = getConn().createStatement(); 
		String sql = "select id, nome, descricao, preco from produto";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Produto p = new Produto();
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));	
			p.setDescricao(rs.getString(3));
			p.setPreco(rs.getBigDecimal(4));
			lst.add(p);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
		
	}
	
	public void newProduto(Produto p) throws Exception {
		
		  abrir();		
	      String query = " insert into produto (nome, descricao, preco)"
	        + " values (?,?,?)";
 		PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, p.getNome());  
	      preparedStmt.setString (2, p.getDescricao());  
	      preparedStmt.setBigDecimal(3, p.getPreco()); 
	      preparedStmt.execute();
	      fechar();
		
	}
	
	public void delete() throws Exception {
		  abrir();
	      String query = " delete from produto where id=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setInt(1,vo.getId());    
	      preparedStmt.execute();
	      fechar();	
	}
	
	public ArrayList<Produto> findProduto (String nome) throws Exception{
		
		super.abrir();
		ArrayList<Produto> lst = new ArrayList<>();
		String query = "SELECT id, nome ,descricao, preco from produto where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString (1, nome +'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		
		while(rs.next()) {
			Produto produto = new Produto();
			produto.setId(Integer.parseInt(rs.getString(1)));
			produto.setNome(rs.getString(2));
			produto.setDescricao(rs.getString(3));
			produto.setPreco(rs.getBigDecimal(4));
			lst.add(produto);
			
		}
		
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}
	
	public Produto findByIdProduto(int id) throws Exception{
		super.abrir();
		
		String sql = "SELECT id,nome,descricao,preco FROM Produto where id=?";
		  
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setInt(1, id);  
		  
		ResultSet rs =   preparedStmt.executeQuery();
		Produto p= new Produto();
		while (rs.next()) { 
			p.setId(Integer.parseInt(rs.getString(1)));
			p.setNome(rs.getString(2));		
			p.setDescricao(rs.getString(3));	
			p.setPreco(rs.getBigDecimal(4)); 
		}
		
		rs.close();
		return p;
	}
	
	public void edit(Produto p)  throws Exception{
		abrir();
			
		  String query = " update Produto set nome=?,descricao=?,preco=? where id=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, p.getNome());  
	      preparedStmt.setString (2, p.getDescricao());  
	      preparedStmt.setBigDecimal(3, p.getPreco()); 
	      preparedStmt.setInt(4, p.getId()); 
	      preparedStmt.execute();
	      fechar();
		
	}
}
