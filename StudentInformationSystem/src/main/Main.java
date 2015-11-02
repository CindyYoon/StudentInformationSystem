package main;

import java.util.Scanner;
import func_add.*;
import func_delete.*;
import func_update.Update_student;
//import func_update.*;
//import func_view.*;
import func_view.View_student;

public class Main {
	
	static int menu_choice;		// �޴� ����
	static int switch_out=0;	// ���� ����

	public static void main(String args[]) throws Exception	{
		Scanner input_menu = new Scanner(System.in);
		
		while (switch_out==0) {
			System.out.println("[ �� �� �� �� �� �� �� ]");
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ���� ����");
			System.out.println("3. �л� ���� ����");
			System.out.println("4. �л� ���� ���");
			System.out.println("5. ����");
			System.out.print("-> ");
			menu_choice = input_menu.nextInt();
			
			switch(menu_choice) {
				case 1:
					Add_student.studentinfo_add();
					break;
				case 2:
					Delete_student.studentinfo_delete();
					break;
				case 3:
					Update_student.studentinfo_update();
					break;
				case 4:
					View_student.View();
					break;
				case 5:
					switch_out=1;
					break;
				default :
					System.out.println("�޴� ��ȣ�� Ȯ���Ͻð� �Է��ϼ���.");
			}
		}
	}
}