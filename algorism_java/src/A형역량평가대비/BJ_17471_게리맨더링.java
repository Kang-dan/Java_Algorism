package A형역량평가대비;

import java.util.*;
import java.io.*;

public class BJ_17471_게리맨더링 {

	static int N;
	static int resultMin, totalCnt;
	static int[] pCnt;
	static int[][] adj;
	
	static boolean[] check1, check2; //연결여부 확인용 
	static int[] one; //구역1 
	static int[] two; //구역2
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		pCnt = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pCnt[i] = Integer.parseInt(st.nextToken());
			totalCnt += pCnt[i]; //전체 인구수 
		}
		
		//인접리스트 
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i][to - 1] = 1;
				adj[to - 1][i] = 1;
			}
		}
		
		resultMin = Integer.MAX_VALUE;
		부분집합();
		
		bw.write(resultMin+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void 부분집합() {
		int idx1, idx2;
		int sum1, sum2;
		for(int i = 1; i < Math.pow(2, N)-1; i++) {
			idx1 = 0; idx2 = 0; sum1 = 0; sum2 = 0;
			one = new int[N];
			two = new int[N];
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					one[idx1++] = j; //선택한 정점 넣어주기 
					sum1 += pCnt[j]; // 한구역의 인구 
				} else {
					two[idx2++] = j;
					sum2 += pCnt[j];
				}
			}
			
			//두 구역이 각각 서로 연결되어있는지 확인하기 
			check1 =  new boolean[N];
			int index = 0;
			for(int a = 0; a < idx1-1; a++) { //선택한 정점 수 만큼 
				for(int j = 0; j < N; j++) {
					if(one[a] == j && adj[one[a]][j] == 1) check1[j] = true;
				}
			}
			
			check2 = new boolean[N];
			index = 0;
			for(int a = 0; a < idx2-1; a++) { //선택한 정점 수 만큼 
				for(int j = 0; j < N; j++) {
					if(two[a] == j && adj[two[a]][j] == 1) check2[j] = true;
				}
			}
			
			int out = 0;
			for(int j = 0; j < N; j++) {
				if(one[j] != 0 && !check1[j]) {
					out = 1;
					break;
				}
			}
			
			for(int j = 0; j < N; j++) {
				if(two[j] != 0 && !check2[j]) {
					out = 1;
					break;
				}
			}
			
			if(out == 1) continue;
			else {
				//더 차이가 작은 값으로 갱신
				Math.min(Math.abs(sum1 - sum2), resultMin);
			}
			
		}
		
		if(resultMin == Integer.MAX_VALUE) resultMin = -1;
		
	}

}
