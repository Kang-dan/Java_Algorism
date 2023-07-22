package algorism_java;

import java.util.*;

public class java_SWEA_1979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] puzzle = new int[N+K][N+K];
			
			//입력 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			int result = 0; //최종 개수
			int cnt = 0, k; //K자리수 세기 
			//가로 탐색 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(puzzle[i][j]==1 && j+K<N) {
						for( k=j; k<j+K; k++) {
							if(puzzle[i][k]==0) {
								j=k;
								break;
							}
							cnt++;
						}
						if(cnt==K) {
							j = k;
							if(puzzle[i][j+1]==0) result++;
							else if(j==N-1) result++;
						}
					}
				}
			}
			
			//세로 탐색
			for(int j=0; j<N; j++) {
				for(int i=0; i<N; i++) {
					if(puzzle[i][j] == 1 && i+K<N) {
						cnt=1;
						for(k=i+1; k<i+K-1; k++) {
							if(puzzle[i][k]==0) {
								i = k;
								break;
							}
							else cnt++;
						}
						if(cnt==K) {
							result++;
							i = k-1;
						}
					}
					
				}
			}
			System.out.println("#"+test_case+" "+result);
			
		}
		
	}

}
