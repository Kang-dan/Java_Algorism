package algorism_java;

import java.util.Scanner;

public class java_SWEA_1289_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			String bit = sc.next(); //원래 비트값 입력 
			
			int cnt = 0; //고치는 수 
			int flag = 0; //0과 1 토글역할 
			for(int i=0; i<bit.length(); i++) {
				if(bit.charAt(i) == '1' && flag == 0) {
					flag = 1;
					cnt++;
				}else if(bit.charAt(i)=='0' && flag == 1){
					flag = 0;
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
			
		}

	}

}
