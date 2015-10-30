package func_update;

import java.sql.*;

public class Update_student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "1234";
		String dbURL = "jdbc:mysql://localhost:3306/swe2015";
		Connection conn = null;
		Statement stmt = null;
		
		//DB ���� Ȯ��
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(dbURL, user, pass);
//			System.out.println("Driver found! Connection Good!");
//		} catch(SQLException se) {
//			System.out.println("sql error");
//		} catch(ClassNotFoundException cne) {
//			System.out.println("jdbc driver not founded!");
//		}
		
		//UPDATE ��� ����
		try {
			
			//DB ����
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, user, pass);
			//SQL��
			String sql = "UPDATE student SET phone_number='01012341234' WHERE name='������'";
			stmt = conn.createStatement();	//DB ���� �õ�
			
			//�������� DB�� �����ϰ� �� ���޹���
			int result = stmt.executeUpdate(sql);
			if (result == 1) {	//1�� �� ���� ���� ����
				System.out.println("���� ���� ����");
			} else {
				System.out.println("���� ���� ����");
			}
			
		} catch(SQLException e) {
			System.out.println("sql error");
		} catch(ClassNotFoundException e) {
			System.out.println("jdbc driver not founded!");
		} finally {
			//����� Statement, resultset, Connection �ڿ� �ݳ�
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException e) {
					System.out.println("sql error");
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("sql error");
				}
			}
		}

	}

}
