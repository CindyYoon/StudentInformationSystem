package func_update;

import java.sql.*;
import java.util.Scanner;

import util.DatabaseQuery;

public class Update_student {
	
	static int input_id = 0;	// �й� �Է�
	static int occur_Existence;		// �ش� �й� ���� �л� �ִ��� ���� Ȯ�� 
	static String input_phonenumber; // ��ȭ��ȣ �Է�

	//�Է¹޾Ƽ� �� �ֱ�
	public static void studentinfo_update() throws Exception {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("��ȭ��ȣ�� ������ �л��� �й��� �Է��ϼ��� : ");
			input_id = scan.nextInt();
			
			// ���翩�� üũ �Լ�(=�ߺ� üũ �Լ�) ȣ��
			isExistence(input_id);
			
			if (occur_Existence == 1) {	// ����
				// ������ ��ȭ��ȣ �Է� ����
				System.out.print("���ο� ��ȭ��ȣ�� �Է��ϼ��� : ");
				input_phonenumber = scan.next();
				
				// ���� �Լ� ȣ��
				updateStudentToDatabase(input_id, input_phonenumber);
				break;
			} else if (occur_Existence == 0) {	// �������� ����
				System.out.println("-> �������� �ʴ� �й��Դϴ�.");
				System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
			}
			
		}
		
	}
	
	public static void isExistence(int input_id) {
		int id = input_id;
		int existence;
		
		// DB���� ���� �й� ã��
		existence = DatabaseQuery.Database_Checkstudent(id);
		
		// �ش� �л��� �����ϴ��� ����
		if (existence > 0) {
			occur_Existence = 1; // ����
		} else if (existence == 0) {
			occur_Existence = 0; // �������� ����
		}
	}
	
	public static void updateStudentToDatabase(int id, String phonenum) {
		try {
			// DB�� ����
			DatabaseQuery.Database_Updatestudent(id, phonenum);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

}
