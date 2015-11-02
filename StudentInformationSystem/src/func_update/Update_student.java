package func_update;

import java.sql.*;
import java.util.Scanner;

import util.DatabaseQuery;

public class Update_student {
	
	static int input_id = 0;	// 학번 입력
	static int occur_Existence;		// 해당 학번 가진 학생 있는지 여부 확인 
	static String input_phonenumber; // 전화번호 입력

	//입력받아서 값 넣기
	public static void studentinfo_update() throws Exception {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("전화번호를 수정할 학생의 학번을 입력하세요 : ");
			input_id = scan.nextInt();
			
			// 존재여부 체크 함수(=중복 체크 함수) 호출
			occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
			
			if (occur_Existence == 1) {	// 존재
				// 수정할 전화번호 입력 받음
				System.out.print("새로운 전화번호를 입력하세요 : ");
				input_phonenumber = scan.next();
				// 저장 함수 호출
				DatabaseQuery.Database_Updatestudent(input_id, input_phonenumber);
				break;
			} else if (occur_Existence == 0) {	// 존재하지 않음
				System.out.println("-> 존재하지 않는 학번입니다.");
				System.out.println("-> 다시 작성해 주세요.\n");
			}
			
		}
		
	}

}
