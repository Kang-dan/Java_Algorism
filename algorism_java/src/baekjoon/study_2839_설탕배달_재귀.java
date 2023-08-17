package baekjoon;

import java.util.*;
import java.io.*;

public class study_2839_설탕배달_재귀 { //4일때, 7일때 다시 생각하기 
	static int ans = -1;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
/*그리디*/	
		if( N == 4 || N == 7) {
			bw.write("-1");
			bw.flush();
			return;
		}
		int ans = N / 5;
		if (N % 5 == 1 || N % 5 == 3) {
			ans ++;
		} else if (N % 5 == 2 || N % 5 == 4) {
			ans += 2;
		}
		bw.write(ans+"");
		bw.flush();
		
		bw.close();
		br.close();

/* DP*/
//		//N까지 배열 만들기 (모두 맥스로 채우기)
//		int[] map = new int[N+1];
//		for(int i = 0; i <= N; i++) {
//			map[i] = N + 999999;
//		}
//		
//		//3키로 배수는 증감 
//		int cnt = 1;
//		for(int i = 3; i <= N; i++) {
//			if(i % 3 == 0) map[i] = cnt++;
//		}
//		
//		//5키로 배수 확인 
//		cnt = 1;
//		for(int i = 5; i <= N; i++) {
//				if(map[i-5] + 1 < map[i]) {
//					map[i] = map[i-5] + 1;
//				}
//			
//		}
//		
//		if(map[N] == N + 999999) bw.write("-1");
//		else bw.write(map[N]+"");
//		
//		bw.flush();
//		bw.close();
		
		
		
//		
//		int cnt = 0;
//		search(0, 0);
//		bw.write(ans+"");
//
//	}
//
//	private static void search(int kg, int cnt) {
//		if( ans != -1) return;
//		if( kg == N ) {
//			ans = cnt;
//			return;
//		}
//		if( kg > N ) return;
//		
//		search(kg + 5, cnt + 1);
//		search(kg + 3, cnt + 1);
//	}
		
	}
	
}
