package func_view;

import java.sql.*;
import java.util.Scanner;

public class View_student {
	
	protected Statement stat = null;
	protected Connection conn = null;
	int id;  // �й� �Է�
	String name; // �̸� �Է�
	String department; //�а� �Է�
	int number;
	
	private void View_student() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sw2015";

			conn = DriverManager.getConnection(url, "root", "1234");
			stat = conn.createStatement();
			//initialize();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	
	public void View(int id, String name, String department, int number ) throws Exception {
		
		ResultSet rs = null;
		Scanner input_some = new Scanner(System.in);

		System.out.println("�й� : ");
		id = input_some.nextInt();
		
		if(id == 0){
			System.out.println("�����ϴ� ID�� ���� �л��� �����ϴ�.");
		}else {
			rs = stat.executeQuery("select* from StudentInformation when ID");
				
			while(rs.next()){
				id = rs.getInt(1);
				name = rs.getString(2);
				department = rs.getString(3);
				number = rs.getInt(4);

			System.out.println(id + "\t" +name+ "\t" +department+  "\t" +number+ "\t" +"\n");
		    }
		}
		
	}

}