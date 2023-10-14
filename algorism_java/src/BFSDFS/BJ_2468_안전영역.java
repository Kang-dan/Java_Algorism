package BFSDFS;

import java.util.*;
import java.io.*;

public class BJ_2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int resultCnt = 1, sum;
		for(int c = 0; c <= 101; c++) {
			visit = new boolean[N][N];
			sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visit[i][j] && map[i][j] > c) {
						bfs(i, j, c);
						sum++;
					}
				}
			}
			resultCnt = Math.max(resultCnt, sum);
		}
		
		bw.write(resultCnt + "");
		
		bw.flush();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};
	
	private static void bfs(int r, int c, int rain) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int y = v[0] + dr[d];
				int x = v[1] + dc[d];
				
				if(y < 0 || y >= N || x < 0 || x >= N || visit[y][x]) continue;
				
				if(map[y][x] > rain) {
					q.offer(new int[] {y, x});
					visit[y][x] = true;
				}
			}
		}
	}

}
