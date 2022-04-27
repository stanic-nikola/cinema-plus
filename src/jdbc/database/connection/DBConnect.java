package jdbc.database.connection;

import java.sql.Connection;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Class for the connection with database
public class DBConnect {
	static Connection con = null;
	static Statement stmt = null;
	
	public static Connection getConnection()
	{
		try
		{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/cinemaplus");
			
			con = ds.getConnection();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
}
