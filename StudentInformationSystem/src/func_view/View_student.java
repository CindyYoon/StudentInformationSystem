package func_view;

import java.sql.*;
import java.util.Scanner;

public class View_student {
	
	protected static Statement stat = null;
	protected static Connection conn = null;
	static int id;  // �й� �Է�
	static String name; // �̸� �Է�
	static String department; //�а� �Է�
	static int phone_number;
	
//	private void View_student() {
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/sw2015";
//
//			conn = DriverManager.getConnection(url, "root", "1234");
//			stat = conn.createStatement();
//			//initialize();
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
//	}
	

	public static void View() throws Exception {
	//public void View(int id, String name, String department, int phone_number ) throws Exception {
		
		ResultSet rs = null;
		Scanner input_some = new Scanner(System.in);

		System.out.println("�й� : ");
		id = input_some.nextInt();
		
		if(id == 0){
			System.out.println("�����ϴ� ID�� ���� �л��� �����ϴ�.");
		}else {
			rs = stat.executeQuery("select* from StudentInformation when ID='"+id+"'");
				
//			while(rs.next()){
//				id = rs.getnextInt();
//				name = rs.getString(2);
//				department = rs.getString(3);
//				phone_number = rs.getInt(4);

//			System.out.println(id + "\t" +name+ "\t" +department+  "\t" +phone_number+ "\t" +"\n");
//		    }
		}
	}
		
}