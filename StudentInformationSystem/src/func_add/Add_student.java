package func_add;
import java.util.Scanner;
import java.io.FileInputStream;

public class Add_student {

	int duple; // �ߺ����� �ƴ����� ��� ����
	
	//�Է¹޾Ƽ� �� �ֱ�
	public void main(String args[]) throws Exception	{
		int input_id = 0;  // �й� �Է�
		String input_name; // �̸� �Է�
		String input_depart; //�а� �Է�
        
		Scanner input_some = new Scanner(System.in);
		
		while (true) {
			System.out.println("�й� : ");
			input_id = input_some.nextInt();
			System.out.println("�̸� : ");
			input_name = input_some.next();
			System.out.println("�а� : ");
			input_depart = input_some.nextLine();
		
			//�ߺ� üũ �Լ� ȣ��
			duple_check(input_id);
		
			
			if (duple == 1) {
				System.out.println("-> �̹� �߰��� �й��Դϴ�.\n");
				System.out.println("-> �ٽ� �ۼ��� �ּ���.\n");
			} else if (duple == 0) {
				// ���� �Լ� ȣ��
				System.out.println("-> ���������� �л������� �߰��Ǿ����ϴ�.\n");
				break;
			}
		}
	}
	
	public void duple_check(int input_id) {
		int inputid = input_id;
		int duple_id = 0;
		
		//�Է¹��� �й��� DB�� �й� �ߺ� ã��
		
		//�ߺ� ������ �ߺ����� ���
		if (duple_id >= 0) {
			duple = 1; // �ߺ�
		} else if (duple_id == 0) {
			duple = 0; // �ߺ� ����
		}
	}
}