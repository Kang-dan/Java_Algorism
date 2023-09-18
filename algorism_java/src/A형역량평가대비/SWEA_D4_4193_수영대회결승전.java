package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_D4_4193_수영대회결승전 {

	static int N, resultCnt;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visit = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine()); //출발지점
			int sY = Integer.parseInt(st.nextToken());
			int sX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()); //도착지점 -1
			int eY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			map[eY][eX] = -1; //도착지점 
			
			resultCnt = 0;
			int result = bfs(sY, sX);
			bw.write(String.format("#%d %d\n", test, result)); //출발 지점
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dy = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dx = {1, 0, -1, 0};
	
	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {sy, sx});
		visit[sy][sx] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			resultCnt++;
			
			for(int i = 0; i < size; i++) {
				int[] v = q.poll();
				int y = v[0];
				int x = v[1];
			
				for(int d = 0; d < 4; d++) {
					int a = y + dy[d];
					int b = x + dx[d];
					
					if(a < 0 || a >= N || b < 0 || b >= N) continue; //배열 범위 
					if(visit[a][b]) continue; // 이미 방문했으면 스킵 
					
					if(map[a][b] == -1) {
						return resultCnt;
					}
					
					//0이면 큐에 넣기 
					if(map[a][b] == 0) {
						q.offer(new int[] {a, b});
						visit[a][b] = true;
					}
					
					//2이고 3의 배수이면 넣기 
					if(map[a][b] == 2 && resultCnt >= 3 && resultCnt % 3 == 0) {
						q.offer(new int[] {a, b});
						visit[a][b] = true;
					}
					
					//2이고 3의 배수가 아니면 자기자신 다시 넣기 
					if(map[a][b] == 2 && (resultCnt < 3 || resultCnt % 3 != 0)) {
						q.offer(new int[] {y, x});
						visit[y][x] = true;
					}
				}
			}
			
			
		}
		return -1;
	}

}
