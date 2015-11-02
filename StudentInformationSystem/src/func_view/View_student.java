package func_view;

import java.sql.*;
import java.util.Scanner;

import util.DatabaseQuery;

public class View_student {
	
	static int input_id;  // 학번 입력
	static int occur_Existence;		// 해당 학번 가진 학생 있는지 여부 확인

	public static void studentinfo_view() throws Exception {
		Scanner scan = new Scanner(System.in);
		
		while (true) {

			System.out.print("학번을 입력하세요 : ");
			input_id = scan.nextInt();
			
			// 존재여부 체크 함수(=중복 체크 함수) 호출
			occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
			
			if (occur_Existence == 1) {	// 존재
				// 해당 ID를 가진 학생의 정보를 보여줌
				DatabaseQuery.Database_Viewstudent(input_id);
				break;
			} else if (occur_Existence == 0) {	// 존재하지 않음
				System.out.println("-> 존재하지 않는 학번입니다.");
				System.out.println("-> 다시 작성해 주세요.\n");
			}
		}
	}
		
}