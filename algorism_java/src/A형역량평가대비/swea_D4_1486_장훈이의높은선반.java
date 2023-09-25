package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_D4_1486_장훈이의높은선반 {

	static int pCnt, B; //직원 수, 최소 높이 
	static int resultLen; //결과 높이 
	static int[] pH; //직원들 키 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int tCnt = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			pCnt = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			pH = new int[pCnt];
			for(int i = 0; i < pCnt; i++) {
				pH[i] = Integer.parseInt(st.nextToken());
			}
			
			resultLen = Integer.MAX_VALUE;
			부분집합바이너리카운팅();
			
			bw.write(String.format("#%d %d\n", test, Math.abs(B-resultLen)));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void 부분집합바이너리카운팅() {
		int sum;
		for(int i = 0; i < Math.pow(2, pCnt); i++) {
			sum = 0;
			for(int j = 0; j < pCnt; j++) {
				if((i & (1 << j)) != 0) {
					sum += pH[j];
				}
			}
			//더한값이 B 미만이면 패스 
			if(sum < B) continue;
			//더한값이 min < 새로 구한 값 이면 패스
			else if(resultLen < sum) continue;
			//더한값이 B < 새로더한 값 < min 이면 갱신 
			else if(B <= sum && sum < resultLen) {
				resultLen = sum;
			}
		}
	}

}
