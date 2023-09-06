package 스터디;

import java.util.*;
import java.io.*;

public class BJ_2225_합분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K + 1][N + 1];
		for(int i = 1; i <=K; i++) {
			dp[i][0] = 1;
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= 1000000000;
			}
		}
		bw.write(dp[K][N]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}