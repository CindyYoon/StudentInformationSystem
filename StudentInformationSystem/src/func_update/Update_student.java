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
		
		//DB 연동 확인
//		try{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(dbURL, user, pass);
//			System.out.println("Driver found! Connection Good!");
//		} catch(SQLException se) {
//			System.out.println("sql error");
//		} catch(ClassNotFoundException cne) {
//			System.out.println("jdbc driver not founded!");
//		}
		
		//UPDATE 기능 구현
		try {
			
			//DB 연동
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, user, pass);
			//SQL문
			String sql = "UPDATE student SET phone_number='01012341234' WHERE name='선한이'";
			stmt = conn.createStatement();	//DB 연결 시도
			
			//쿼리문을 DB에 전달하고 값 전달받음
			int result = stmt.executeUpdate(sql);
			if (result == 1) {	//1일 때 쿼리 실행 성공
				System.out.println("쿼리 실행 성공");
			} else {
				System.out.println("쿼리 실행 실패");
			}
			
		} catch(SQLException e) {
			System.out.println("sql error");
		} catch(ClassNotFoundException e) {
			System.out.println("jdbc driver not founded!");
		} finally {
			//사용한 Statement, resultset, Connection 자원 반납
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
