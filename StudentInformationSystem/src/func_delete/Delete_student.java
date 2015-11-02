package func_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import util.DatabaseQuery;
 
 
public class Delete_student {
	static int occur_Existence;		// 해당 학번 가진 학생 있는지 여부 확인 
	
	public static void studentinfo_delete() throws Exception{

		Scanner sc = new Scanner(System.in);

		// 내용 삭제
		System.out.print("삭제 할 학생의 학번을 입력해주세요. : ");
		int input_id = sc.nextInt();
		
		//중복 체크 함수 호출
		// DB에서 같은 학번 찾기
		occur_Existence = DatabaseQuery.Database_Checkstudent(input_id);
		
		if (occur_Existence < 0) {
			System.out.println("-> 존재하지 않는 학번입니다.");
			System.out.println("-> 다시 작성해 주세요.\n");
		}else {
			// 삭제 함수 호출
			DatabaseQuery.Database_Deletestudent(input_id);	
		}
				 		 
		return;
    }
	
}