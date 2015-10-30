package func_add;

import java.util.Scanner;
//import java.io.FileInputStream;
import util.DatabaseQuery;

public class Add_student {

	static int occur_duplecation; // �ߺ����� �ƴ����� ��� ����
	static int input_id = 0;  // �й� �Է�
	static String input_name; // �̸� �Է�
	static String input_depart; //�а� �Է�
	static String input_phonenumber; // ��ȭ��ȣ �Է�
	
	//�Է¹޾Ƽ� �� �ֱ�
	public static void main(String args[]) throws Exception	{
		Scanner input_some = new Scanner(System.in);
		
		while (true) {
			System.out.println("��     �� : ");
			input_id = input_some.nextInt();
			System.out.println("��     �� : ");
			input_name = input_some.next();
			System.out.println("��     �� : ");
			input_depart = input_some.next();
			System.out.println("��ȭ��ȣ : ");
			input_phonenumber = input_some.next();
		
			//�ߺ� üũ �Լ� ȣ��
			isDuplication(input_id);
			
			if (occur_duplecation == 1) {
				System.out.println("-> �̹� �߰��� �й��Դϴ�.");
				System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
			} else if (occur_duplecation == 0) {
				// ���� �Լ� ȣ��
				addStudentToDatabase(input_id, input_name, input_depart, input_phonenumber);
				System.out.println("-> ���������� �л������� �߰��Ǿ����ϴ�.\n");
				break;
			}
		}
	}
	
	public static void isDuplication(int input_id) {
		int id = input_id;
		int duplicate;
		
		// DB���� ���� �й� ã��
		duplicate = DatabaseQuery.Database_Checkstudent(id);
		
		//�ߺ� ������ �ߺ����� ���
		if (duplicate > 0) {
			occur_duplecation = 1; // �ߺ�
		} else if (duplicate == 0) {
			occur_duplecation = 0; // �ߺ� ����
		}
	}
	
	public static void addStudentToDatabase(int id, String name, String depart, String phonenum) {
		try {
			// DB�� ����
			DatabaseQuery.Database_Addstudent(id, name, depart, phonenum);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
}