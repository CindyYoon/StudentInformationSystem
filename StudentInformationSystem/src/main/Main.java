package main;

import java.util.Scanner;
import func_add.*;
import func_delete.*;
import func_update.Update_student;
//import func_update.*;
//import func_view.*;

public class Main {
	
	static int menu_choice; // �޴� ����

	public static void main(String args[]) throws Exception	{
		Scanner input_menu = new Scanner(System.in);
		
		while (true) {
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
			case 2:
			case 3:
				Update_student.studentinfo_update();
			case 4:
			case 5:
				break;
			default :
				System.out.println("�޴� ��ȣ�� Ȯ���Ͻð� �Է��ϼ���.");
			}
		}
	}
}