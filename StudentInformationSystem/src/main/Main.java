package main;

import java.util.Scanner;
import func_add.*;
import func_delete.*;
import func_update.Update_student;
//import func_update.*;
//import func_view.*;

public class Main {
	
	static int menu_choice; // 메뉴 선택

	public static void main(String args[]) throws Exception	{
		Scanner input_menu = new Scanner(System.in);
		
		while (true) {
			System.out.println("[ 학 생 정 보 시 스 템 ]");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 삭제");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 출력");
			System.out.println("5. 종료");
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
				System.out.println("메뉴 번호를 확인하시고 입력하세요.");
			}
		}
	}
}