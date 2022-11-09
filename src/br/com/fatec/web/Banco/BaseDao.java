package br.com.fatec.web.Banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {

	private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/webfatec?useTimezone=true&server"
    						+ "Timezone=UTC";
    
    private String user = "root";
    private String password = "vaisantos1";

    private Connection conn;
     
   	public Connection getConn() {
		return conn;
	}
   	
    public  void abrir() throws Exception {       
        Class.forName(driver);     
        conn = DriverManager.getConnection(url, user, password); 
        System.out.println("abriu");
    }

    public  void fechar() throws Exception {
        this.getConn().close();        
    }
       
}
