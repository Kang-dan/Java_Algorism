/* 4047.영준이의 카드 카운팅
최근 영준이는 카드 게임에 꽂혀 있다.
영준이가 하는 카드 게임에는 한 덱의 카드가 필요한데 여기서 얘기하는 “한 덱”이란 스페이드, 다이아몬드, 하트, 클로버 무늬 별로 각각 A, 2~10, J, Q, K의 라벨 즉 4개의 무늬 별로
각각 13장씩 총 52장의 카드가 있는 모음을 의미한다.
편의상 A는 1, J, Q, K는 11, 12, 13으로 하여 1~13의 숫자가 카드에 적혀있다고 하자.
영준이는 몇 장의 카드를 이미 가지고 있는데 게임을 하기 위해서 몇 장의 카드가 더 필요한지 알고 싶어 한다.
그리고 이미 겹치는 카드를 가지고 있다면 오류를 출력하고자 한다.
지금 가지고 있는 카드의 정보가 주어지면 이 작업을 수행하는 프로그램을 작성하라.

[입력]
맨 위 줄에 테스트케이스의 개수가 주어진다.
각 테스트케이스 별로 순서대로 첫 번째 줄에 지금 영준이가 가지고 있는 카드에 대한 정보 S (1 ≤ |S| ≤ 1000)가 주어진다.
S는 각각 3자리로 표현되는 카드들의 정보를 붙여서 만든 하나의 문자열인데 각 카드는 TXY 꼴로 표현되며,
T는 카드의 무늬(S, D, H, C)이며 XY는 카드의 숫자 (01 ~ 13)이다.

[출력]
각 테스트케이스 별로 순서대로 한 줄씩 답을 출력하는데, 문자열 S를 보고 지금 무늬 별로(S, D, H, C 순서로) 몇 장의 카드가 부족한지 출력하여라.
이미 겹치는 카드가 있다면 문자열 “ERROR” (쌍따옴표는 출력하지 않는다)를 출력한다
 */

package algorism_java;

import java.util.Scanner;

public class java_SWEA_4047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int result = 0;
		for(int test_case=1; test_case<=T; test_case++) {
			result =0;
			String info = sc.next();
			
			int[][][] flag = new int[4][2][10];//겹치는 숫자가 있는지 확인 
			int[] count = new int[4]; //SDHC별 카드 개수
			int i;
			for(i=0; i<info.length(); i+=3) {
				int a = info.charAt(i+1) - '0';
				int b = info.charAt(i+2) - '0';
				
				if(info.charAt(i) == 'S') {
					flag[0][a][b]++;
					if(flag[0][a][b] > 1) {
						result++;
						System.out.println("#"+test_case+" ERROR");
						break;
					} else count[0]++;
				}else if(info.charAt(i) == 'D') {
					flag[1][a][b]++;
					if(flag[1][a][b] > 1) {
						result++;
						System.out.println("#"+test_case+" ERROR");
						break;
					} else count[1]++;
				}else if(info.charAt(i) == 'H') {
					flag[2][a][b]++;
					if(flag[2][a][b] > 1) {
						result++;
						System.out.println("#"+test_case+" ERROR");
						break;
					} else count[2]++;
				}else if(info.charAt(i) == 'C') {
					flag[3][a][b]++;
					if(flag[3][a][b] > 1) {
						result++;
						System.out.println("#"+test_case+" ERROR");
						break;
					} else count[3]++;
				}
			}
			if(result == 0) System.out.printf("#%d %d %d %d %d\n", test_case, 13-count[0], 13-count[1], 13-count[2], 13-count[3]);
			
		}
	}

}
