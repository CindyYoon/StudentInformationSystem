package func_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import util.DatabaseQuery;
 
 
public class Delete_student {
	static int occur_Existence;		// �ش� �й� ���� �л� �ִ��� ���� Ȯ�� 
	
	public static void studentinfo_delete() throws Exception{

		Scanner sc = new Scanner(System.in);

		// ���� ����
		System.out.print("���� �� �л��� �й��� �Է����ּ���. : ");
		int input_id = sc.nextInt();
		
		//�ߺ� üũ �Լ� ȣ��
		// DB���� ���� �й� ã��
		occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
		
		if (occur_Existence < 0) {
			System.out.println("-> �������� �ʴ� �й��Դϴ�.");
			System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
		}else {
			// ���� �Լ� ȣ��
			DatabaseQuery.Database_Deletestudent(input_id);	
		}
				 		 
		return;
    }
	
}