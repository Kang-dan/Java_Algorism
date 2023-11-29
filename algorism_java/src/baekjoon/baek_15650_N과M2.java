package baekjoon;

import java.util.*;
import java.io.*;

public class baek_15650_N과M2 {

	static int N, M;
	static int[] input;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[M+1];
		
		com(0, 1);
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static void com(int cnt, int start) throws IOException {
		if(cnt == M) {
			//출력
			for(int i = 0; i < M; i++) {
				bw.write(input[i] + " ");
			}
			bw.write("\n");
			
			return;
			
		}
		for(int i = start; i <= N; i++) {
			input[cnt] = i;
			com(cnt+1, i+1);
		}
		
	}

}
