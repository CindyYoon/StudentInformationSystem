package func_view;

import java.sql.*;
import java.util.Scanner;

import util.DatabaseQuery;

public class View_student {
	
	static int input_id;  // �й� �Է�
	static int occur_Existence;		// �ش� �й� ���� �л� �ִ��� ���� Ȯ��

	public static void studentinfo_view() throws Exception {
		Scanner scan = new Scanner(System.in);
		
		while (true) {

			System.out.print("�й��� �Է��ϼ��� : ");
			input_id = scan.nextInt();
			
			// ���翩�� üũ �Լ�(=�ߺ� üũ �Լ�) ȣ��
			occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
			
			if (occur_Existence == 1) {	// ����
				// �ش� ID�� ���� �л��� ������ ������
				DatabaseQuery.Database_Viewstudent(input_id);
				break;
			} else if (occur_Existence == 0) {	// �������� ����
				System.out.println("-> �������� �ʴ� �й��Դϴ�.");
				System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
			}
		}
	}
		
}