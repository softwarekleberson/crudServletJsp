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
	
}
