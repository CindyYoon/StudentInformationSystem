package func_add;

import java.util.Scanner;
import util.DatabaseQuery;

public class Add_student {

	static int occur_duplecation; // 중복인지 아닌지를 담는 변수
	static int input_id = 0;  // 학번 입력
	static String input_name; // 이름 입력
	static String input_depart; //학과 입력
	static String input_phonenumber; // 전화번호 입력
	
	//입력받아서 값 넣기
	public static void studentinfo_add() throws Exception	{
		Scanner input_some = new Scanner(System.in);
		
		while (true) {
			System.out.print("학     번 : ");
			input_id = input_some.nextInt();
			System.out.print("이     름 : ");
			input_name = input_some.next();
			System.out.print("학     과 : ");
			input_depart = input_some.next();
			System.out.print("전화번호 : ");
			input_phonenumber = input_some.next();
		
			//중복 체크 함수 호출
			isDuplication(input_id);
			
			if (occur_duplecation == 1) {
				System.out.println("-> 이미 추가된 학번입니다.");
				System.out.println("-> 다시 작성해 주세요.\n");
			} else if (occur_duplecation == 0) {
				// 저장 함수 호출
				DatabaseQuery.Database_Addstudent(input_id, input_name, input_depart, input_phonenumber);
				break;
			}
		}
	}
	
	public static void isDuplication(int input_id) {
		int id = input_id;
		int duplicate;
		
		// DB에서 같은 학번 찾기
		duplicate = DatabaseQuery.Database_Checkstudent(id);
		
		//중복 있으면 중복으로 출력
		if (duplicate > 0) {
			occur_duplecation = 1; // 중복
		} else if (duplicate == 0) {
			occur_duplecation = 0; // 중복 없음
		}
	}

}
