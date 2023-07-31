/* 2007. 패턴 마디의 길이
패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.

[제약 사항]
각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.

[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.

[출력]
출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */

package algorism_java;

import java.util.Scanner;

public class java_SWEA_2007 {
	public static int check(String p) {
		for(int i=1; i<p.length()/2; i++) {
			if(p.length()%i==0) {
				String pattern = p.substring(0,i);
				StringBuilder sc =  new StringBuilder(); //append() 사용하기 위해 
				for(int j=0; j<p.length()/i; j++) {
					sc.append(pattern); //패턴 이어붙이기 
				}
				if(sc.toString().equals(p)) {
					return pattern.length();
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			String pattern = sc.next();
			
			int length = check(pattern);
			System.out.printf("#%d %d\n", test_case, length);
		}

	}

}
