package func_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
 
public class Delete_student {
    public static void main(String[] args)
    {
        search();
    }
     
    private static void search(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int r = 0;
         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swe2015", "root","1234");
            //System.out.println("db connect");

			Scanner sc = new Scanner(System.in);

			// ���� ����
			System.out.print("���� �� �л��� �й��� �Է����ּ���. : ");
			String cn = sc.nextLine();
			 
			stmt = (Statement) conn.createStatement();
			r = stmt.executeUpdate("delete from student where ID =" + cn );
			 
			if( r == 0 ){
				System.out.println("���� ��  ������ ã�� �� �����ϴ�.");
			}else{
				System.out.println("���� �Ǿ����ϴ�.");
			}
			System.out.println("");
			search();
			 
			return;
		}
        catch(ClassNotFoundException cnfe){
            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
        }
         
        catch(SQLException se){
            System.out.println(se.getMessage());
        }
         
        try{
             
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}