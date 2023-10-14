package BFSDFS;

import java.util.*;
import java.io.*;

public class SAFFY_A형역량평가_BFS {

	static int N;
	static int[][] map;
	static int[][] visit; //visit[N][N]값이 최종 답 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCnt; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			visit = new int[N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//초기설정1.visit배열을 모두 MAX로 채워두기 
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					visit[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(1, 1, 0); //출발인덱스, cost(비용)
			
			bw.write(String.format("#%d %d\n", t, visit[N][N]));
		}
		
		bw.flush();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};
	
	private static void bfs(int r, int c, int cost) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, cost}); //1, 1, 0 삽입 
		visit[r][c] = cost;
		
		while(!q.isEmpty()) {
			int v[] = q.poll();
			int a = v[0];
			int b = v[1];
			int newCost;
			
			for(int d = 0; d < 4; d++) {
				int y = a + dr[d];
				int x = b + dc[d];
				newCost = v[2]; //초기화 해주기(잊지말자)
				
				//배열 범위 확인 
				if(y <= 0 || y > N || x <= 0 || x > N) continue;
				
				// cost 비용 계산 
				//1. 더 높으면 높이차의 2배 
				if(map[a][b] < map[y][x]) newCost += (map[y][x]-map[a][b]) * 2;
				
				//2. 높이 같으면 +1
				else if(map[a][b] == map[y][x]) newCost++;
				
				//3. 높이 낮으면 그대로 
				
				//방문배열 크기 확인 후 작으면 visit갱신 및 큐 삽입 
				if(visit[y][x] >= newCost) {
					q.offer(new int[] {y, x, newCost});
					visit[y][x] = newCost;
				}
			}
		}
		
	}

}
