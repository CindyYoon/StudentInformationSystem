package util;

import java.sql.*;


public class DatabaseQuery {
	static String Values;
	static String Target;
	static ResultSet resultset;
	static int duplicate = 0;
	
	public static void Database_Addstudent(int id, String name, String depart, String phone)
	{
		try
		{
			Target = "("+ id +", '"+ name + "', '" + depart+ "', '" + phone+"')";
			DatabaseConnect.Database_connect();
			DatabaseConnect.stmt = DatabaseConnect.conn.prepareStatement("Insert into swe2015.student values" + Target);
			DatabaseConnect.stmt.executeUpdate();
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static int Database_Checkstudent(int id)
	{
		duplicate = 0;
		try
		{
			Target = "student.ID = '"+ id+"'";
			
			DatabaseConnect.Database_connect();
			DatabaseConnect.stmt = DatabaseConnect.conn.prepareStatement("Select ID from swe2015.student  where " + Target);
			DatabaseConnect.stmt.executeQuery();
			resultset = DatabaseConnect.stmt.getResultSet();
			if (resultset.next()) {
                duplicate++;
            }
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
}
