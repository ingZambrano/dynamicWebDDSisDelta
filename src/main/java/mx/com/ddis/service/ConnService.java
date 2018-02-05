package mx.com.ddis.service;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean(name = "conService")
@ApplicationScoped
public class ConnService implements Serializable{

	private static final long serialVersionUID = 7482743895713257279L;
	
	public Connection dameConexion(){
		Connection conn = null;
		try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/Delta");
            conn = ds.getConnection();             
            
        } catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
		
		return conn;
		
	}
	
	public void closeConnection(Connection conn,
			PreparedStatement pstmt, ResultSet rs, CallableStatement call) throws SQLException{

		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (call != null) {
			call.close();
		}

	}

}
