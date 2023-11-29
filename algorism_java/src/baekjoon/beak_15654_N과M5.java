package baekjoon;

import java.util.*;
import java.io.*;

public class beak_15654_N과M5 {

	static int N, M;
	static int[] input;
	static int[] result;
	static boolean[] visit;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		result = new int[M];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬 
		Arrays.sort(input);
		
		perm(0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void perm(int cnt) throws IOException {
		if(cnt == M) {
			//출력 
			for(int i = 0; i < M; i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[cnt] = input[i];
			perm(cnt + 1);
			visit[i] = false;
		}
	}

}
