import java.sql.*;
import java.util.Scanner;

public class View_student 
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
				case "view":
					System.out.print("ALL : ");
					Target = input.nextLine();
					Database_view();
					break;
			}
		}
	}
	
	public static void Database_view()
	{
		Connection conn;
		PreparedStatement stmt;

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306" + Database;
		String UserID = "root";
		String UserPassword = "0000";

		try{
			 if(c == view){
				rs = stat.executeQuery("select* from StudentInfo order by ID");
				display.setText(""); 
				display.append("====================================================================" +"\n");
				display.append("");
				display.append("===================================================================="+"\n");
				while(rs.next()){
					String id = rs.getString(1);
					String name = rs.getString(2);
					String department = rs.getString(3);
					String phone_number = rs.getString(4);
					
					display.append(id + "\t" +name+ "\t" +department+  "\t" +phone_number+ "\t" +"\n");
					System.out.println(id + "\t" +name+ "\t" +department+  "\t" +phone_number+ "\t" +"\n");
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}  //sdfsdfsdfsfd
