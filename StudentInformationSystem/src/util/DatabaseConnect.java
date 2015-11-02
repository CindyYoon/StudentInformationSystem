package util;

import java.sql.*;

public class DatabaseConnect {

	static Connection conn;
	static PreparedStatement stmt;

	static String jdbcUrl = "jdbc:mysql://localhost:3306/swe2015";
	static String UserID = "root";
	static String UserPassword = "1234";

	public static void Database_connect()
	{
		try
		{
			conn = DriverManager.getConnection(jdbcUrl, UserID, UserPassword);

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace(); 
		}
	}

	public static void Database_disconnect()
	{
		try { conn.close(); }
		catch (SQLException e) { e.printStackTrace(); }
	}

}
