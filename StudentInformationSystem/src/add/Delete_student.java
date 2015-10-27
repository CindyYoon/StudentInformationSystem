import java.sql.*;
import java.util.Scanner;

public class Delete_student 
{
	static String Database;
	static String Table;
	static String Command;

	static String Headers;
	static String Values;
	static String Target;

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Database Name: ");
		Database = input.nextLine();
		System.out.print("Table Name: ");
		Table = input.nexLine();

		while(true)
		{
			System.out.print("Command ют╥б [insert/show/update/delete]: ");
			command = input.nextLine();
			
			switch (Command)
		    {
				case "delete":
					System.out.print("Target: ");
					Target = input.nextLine();
					Database_delete();
					break;
			}
		}
	}
	
	public static void Database_delete()
	{
		Connection conn;
		PreparedStatement stmt;

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306" + Database;
		String UserID = "root";
		String UserPassword = "0000";

		try
		{
			conn = DriverManager.getConnection(studentSysUrl, UserID, UserPassword);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			stmt = conn.preparedStatement("deletefrom" + Table + "where" + Target.spilt("=")[0] + "=?");
			stmt.setString(1, Target.spilt("=")[1]);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
