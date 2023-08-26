package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_SWTest샘플문제_1767_프로세서연결하기 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			
			Queue<int[]> q = new ArrayDeque<>();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if()
					if(map[i][j] == 1) q.offer(new int[] {i, j}); //프로세서 좌표 넣기 
				}
			}
			
			
			
		}

	}

}
