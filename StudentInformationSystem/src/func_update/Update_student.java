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
			occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
			
			if (occur_Existence == 1) {	// ����
				// ������ ��ȭ��ȣ �Է� ����
				System.out.print("���ο� ��ȭ��ȣ�� �Է��ϼ��� : ");
				input_phonenumber = scan.next();
				// ���� �Լ� ȣ��
				DatabaseQuery.Database_Updatestudent(input_id, input_phonenumber);
				break;
			} else if (occur_Existence == 0) {	// �������� ����
				System.out.println("-> �������� �ʴ� �й��Դϴ�.");
				System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
			}
			
		}
		
	}

}
