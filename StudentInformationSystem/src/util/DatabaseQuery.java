package util;

import java.sql.*;

public class DatabaseQuery {
	static String Values;
	static String Target;
	static String sql;
	static ResultSet resultset;
	static int duplicate = 0;
	
	public static void Database_Addstudent(int id, String name, String depart, String phone)
	{
		try
		{
			Target = "("+ id +", '"+ name + "', '" + depart+ "', '" + phone+"')";
			sql = "Insert into swe2015.student values" + Target;
			DatabaseConnect.Database_connect();
			DatabaseConnect.stmt = DatabaseConnect.conn.prepareStatement(sql);
			DatabaseConnect.stmt.executeUpdate();
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
			System.out.println("-> 성공적으로 학생정보가 추가되었습니다.\n");
		}
		catch (SQLException e)
		{
			System.out.println("-> 학생정보 추가에 실패했습니다.\n");
			e.printStackTrace();
		}
	}
	
	public static void Database_Deletestudent(int id)
	{
		try
		{
			sql = "delete from student where ID =" + id;
			DatabaseConnect.Database_connect();
			DatabaseConnect.stmt = DatabaseConnect.conn.prepareStatement(sql);
			DatabaseConnect.stmt.executeUpdate();	 
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
			System.out.println("-> 성공적으로 학생정보가 삭제되었습니다.\n");
		}
		catch (SQLException e)
		{
			System.out.println("-> 학생정보 삭제에 실패했습니다.\n");
			e.printStackTrace();
		}
	}
	
	public static void Database_Updatestudent(int id, String phone)
	{
		try
		{
			sql = "UPDATE swe2015.student SET phone_number='"+phone+"' WHERE ID='"+id+"'";
			DatabaseConnect.Database_connect();
			DatabaseConnect.stmt = DatabaseConnect.conn.prepareStatement(sql);
			DatabaseConnect.stmt.executeUpdate();
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
			System.out.println("-> 성공적으로 학생정보가 수정되었습니다.\n");
		}
		catch (SQLException e)
		{
			System.out.println("-> 학생정보 수정에 실패했습니다.\n");
			e.printStackTrace();
		}
	}
	
	public static void Database_Viewstudent(int input_id)
	{
		try
		{
			sql = "SELECT * FROM swe2015.student WHERE ID='"+input_id+"'"; 
			DatabaseConnect.Database_connect();
			Statement statement;
			statement = DatabaseConnect.conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("===========================");
				String id = rs.getString("ID");
				System.out.println("  학 번   : " + id);
				String name = rs.getString("name");
				System.out.println("  이 름   : " + name);
				String department = rs.getString("department");
				System.out.println("  전 공   : " + department);
				String phone_number = rs.getString("phone_number");
				System.out.println(" 전화번호 : " + phone_number);
				System.out.println("===========================");
				System.out.println("");
			}
			
			DatabaseConnect.stmt.close();
			DatabaseConnect.Database_disconnect();
			//System.out.println("-> 성공적으로 학생정보가 호출되었습니다.\n");
		}
		catch (SQLException e)
		{
			System.out.println("-> 학생정보 보기에 실패했습니다.\n");
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
