/* 1954. 달팽이 숫자
달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

[예제]
N이 3일 경우,
 
N이 4일 경우,
 
[제약사항]
달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)

[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스에는 N이 주어진다.

[출력]
각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */

package algorism_java;

import java.util.*;
import java.util.Arrays;
import java.io.*;

public class java_SWEA_1954 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[][] num = new int[N+2][N+2]; //0으로 초기화
			
			
			int i=1, j=1, count=1;
			while(count<=N*N) {
				//오른쪽
				while(num[i][j]==0 && j<=N) {
					num[i][j] = count++;
					j++;
				}
				j--; i++;
				//아래
				while(num[i][j]==0 && i<=N) {
					num[i][j] = count++;
					i++;
				}
				i--; j--;
				//왼쪽
				while(num[i][j]==0 && j>=1) {
					num[i][j] = count++;
					j--;
				}
				j++; i--;
				//위
				while(num[i][j]==0 && i>=1) {
					num[i][j] = count++;
					i--;
				}
				i++; j++;
			}
			System.out.println("#"+test_case);
			
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					System.out.printf("%d ", num[a][b]);
				}
				System.out.printf("\n");
			}
		}
		

	}

}
