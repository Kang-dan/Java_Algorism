package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_11054_가장긴증가하는부분수열_DP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int A = Integer.parseInt(br.readLine());
		int[] arr = new int[A];
		int[] dp1 = new int[A];
		int[] dp2 = new int[A];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//DP
		//1. 오름 
		for(int i = 0; i < A; i++) {
			dp1[i] = 1;
			for(int j = 0; j < i; j++) {
				
				//j번째 원소가 i번째 원소보다 작으면서, i번째 dp가 j번째 dp+1값보다 작은 경우 
				if(arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[j] + 1;
				}
			}
		}
		
		//2. 내림 
		for(int i = A-1; i >= 0; i--) {
			dp2[i] = 1;
			for(int j = A-1; j > i; j--) {
				if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[j] + 1;
				}
			}
			
		}
		
		
		int result = 0;
		for(int i = 0; i < A; i++) {
			result = Math.max(result, dp1[i] + dp2[i]);
		}
		
		bw.write(result-1 + "");
		bw.flush();
	}

}
