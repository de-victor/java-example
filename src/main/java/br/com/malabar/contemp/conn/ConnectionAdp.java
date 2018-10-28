package br.com.malabar.contemp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.java.Log;

@Log
public class ConnectionAdp {
	private static final String driver = "org.postgresql.Driver";
	private static final String user = "postgres";
	private static final String senha = "123";
	private static final String url = "jdbc:postgresql://localhost:5432/UNI7";
	private Connection con;
	
	public ConnectionAdp() {
		try {
			this.con = this.conn();
		} catch (Exception e) {
			log.severe("falha na conexão: "+e);
		}
	}
	
	private Connection conn() throws Exception {
		Class.forName(this.driver);
        Connection con = null;
        try {
        	con = (Connection) DriverManager.getConnection(this.url, this.user, this.senha);
        	if(con != null) {
        		return con;
            }
        }
        catch (Exception e) {
        	log.severe("erro na conexao: "+ e);
        	con.close();
		}
        return null;
	}
	
	public ResultSet query(String query) throws Exception {
		return this.con
				   .createStatement()
				   .executeQuery(query);
	}
	
	public void close() throws Exception {
		this.con.close();
	}

}
