package br.com.fatec.web.Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.web.cliente.servlet.Cliente;

public class ClienteDao extends BaseDao{

	public ClienteDao() {

	}
	
	Cliente cli;
	
	public ClienteDao(Cliente cliente) {
		this.cli = cliente;
	}
	
	public Cliente getCli() {
		return cli;
	}
	
	public void setCliente(Cliente cliente) {
		this.cli = cliente;
	}
	
	public void LoadCliente() {
		this.cli.setNome("Nome teste");
		this.cli.setEmail("Teste email");
		this.cli.setTelefone("Teste Telefone");
		
	}
	
	public List<Cliente> getClientes() throws Exception{
		List<Cliente> lst = new ArrayList<Cliente>();
		abrir();
		
		Statement s = getConn().createStatement();
		String sql = "select id, nome, email, telefone from cliente";
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getInt(1));
			cliente.setNome(rs.getString(2));
			cliente.setEmail(rs.getString(3));
			cliente.setTelefone(rs.getString(4));
			lst.add(cliente);
		}
		
		s.close();
		rs.close();
		fechar();
		
		return lst;
	}
	
	public void newCliente(Cliente cliente) throws Exception {
		abrir();
		String query = "insert into cliente (nome, email, telefone)"
						+ " values (?,?,?)";
		
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setString(1, cliente.getNome());
		preparedStatement.setString(2, cliente.getEmail());
		preparedStatement.setString(3, cliente.getTelefone());
		preparedStatement.execute();
		fechar();
	}
	
	public void delete() throws Exception {
		abrir();
		String query = "delete from cliente where id=?";
		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		preparedStatement.setInt(1, cli.getId());
		preparedStatement.execute();
		fechar();
	}
	
	public ArrayList<Cliente> findCliente (String nome) throws Exception{
		
		super.abrir();
		ArrayList<Cliente> lst = new ArrayList<>();
		String query = "SELECT id, nome ,email, telefone from cliente where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString (1, nome +'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		
		while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(rs.getString(1)));
			cliente.setNome(rs.getString(2));
			cliente.setTelefone(rs.getString(3));
			cliente.setEmail(rs.getString(4));
			lst.add(cliente);
			
		}
		
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}
	
	
	public Cliente findByIdCliente(int id) throws Exception {
		super.abrir();
		
		String query = "select id, nome, email, telefone from cliente where id=?";
		
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setInt(1, id);  
		ResultSet rs =   preparedStmt.executeQuery();
		
		Cliente cli = new Cliente();
		while(rs.next()) {
			cli.setId(Integer.parseInt(rs.getString(1)));
			cli.setNome(rs.getString(2));
			cli.setEmail(rs.getString(3));
			cli.setTelefone(rs.getString(4));
		}
		
		rs.close();
		return cli;
	}
	
	public void edit(Cliente cli)  throws Exception{
		abrir();
			
		String query = " update cliente set nome=?,email=?,telefone=? where id=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, cli.getNome());  
	      preparedStmt.setString (2, cli.getEmail());  
	      preparedStmt.setString(3, cli.getTelefone()); 
	      preparedStmt.setInt(4, cli.getId()); 
	      preparedStmt.execute();
	      fechar();
		
	}
	
}
