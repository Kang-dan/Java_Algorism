package algorism_java;

import java.util.*;
import java.io.*;

public class 공부하자 {

	static int N,resultMin;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			visit= new boolean[N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			resultMin = Integer.MAX_VALUE;
			visit[1][1] = true;
			dfs(1, 1, visit, 0);
			
			bw.write(String.format("#%d %d\n", test, resultMin));
		}
		bw.flush();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};

	private static void dfs(int r, int c, boolean[][] visit, int cost) {
		if(r == N && c == N) { //도착하면 갱신 
			resultMin = Math.min(resultMin, cost);
			return;
		}
		
		if(resultMin < cost) return; //백트래킹 
			
		for(int d = 0; d < 4; d++) {
			int y = r + dr[d];
			int x = c + dc[d];
			
			if(y < 1 || y > N || x < 1 || x > N) continue;
			if(visit[y][x]) continue;
			
			visit[y][x] = true;
			
			if(map[r][c] == map[y][x]) {
				dfs(y, x, visit, cost+1);
			}
			
			if(map[r][c] > map[y][x]) {
				dfs(y, x, visit, cost);
			}
			
			if(map[r][c] < map[y][x]) {
				int doubleCost = cost + (map[y][x] - map[r][c])*2;
				dfs(y, x, visit, doubleCost);
			}
		}
	}

}