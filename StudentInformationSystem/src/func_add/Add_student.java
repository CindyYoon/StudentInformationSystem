package func_add;


import java.util.Scanner;
import java.io.FileInputStream;

public class Add_student {

	int duplicate; // 중복인지 아닌지를 담는 변수
	
	//입력받아서 값 넣기
	public void main(String args[]) throws Exception	{
		int input_id = 0;  // 학번 입력
		String input_name; // 이름 입력
		String input_depart; //학과 입력
        
		Scanner input_some = new Scanner(System.in);
		
		while (true) {
			System.out.println("학번 : ");
			input_id = input_some.nextInt();
			System.out.println("이름 : ");
			input_name = input_some.next();
			System.out.println("학과 : ");
			input_depart = input_some.next();
		
			//중복 체크 함수 호출
			isDuplication(input_id);
		
			
			if (duplicate == 1) {
				System.out.println("-> 이미 추가된 학번입니다.\n");
				System.out.println("-> 다시 작성해 주세요.\n");
			} else if (duplicate == 0) {
				// 저장 함수 호출
				System.out.println("-> 성공적으로 학생정보가 추가되었습니다.\n");
				break;
			}
		}
	}
	
	public void isDuplication(int input_id) {
		int inputid = input_id;
		int duplication = 0;
		
		//입력받은 학번과 DB의 학번 중복 찾기
		
		//중복 있으면 중복으로 출력
		if (duplication >= 0) {
			duplicate = 1; // 중복
		} else if (duplication == 0) {
			duplicate = 0; // 중복 없음
		}
	}
}