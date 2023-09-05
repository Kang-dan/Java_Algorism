package 스터디;

import java.util.*;
import java.io.*;

public class BJ_합분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N + 1];
		int[] input = new int[K];
		
		for(int i = 0; i < K; i++) input[i] = i;
		dp[0] = 1;
		for(int i = 1; i <= K; i++) {
			for(int j = input[i]; j <= N; j++) {
				dp[j] += dp[j-input[i]]; //나를 사용하는 경우 + 날 사용하지 않는 경우의 수 
			}
		}
		
		bw.write(dp[N]+"");
		bw.flush();
		
	}

}
//dp[0] = 1;
//for(int i = 0; i < n; i++) { // 동전 개수만큼 
//	for(int j = coin[i]; j <= k; j++) { // 합이 k가 되기까지 경우의 수 누적 
//		dp[j] += dp[j - coin[i]];
//	}
//}