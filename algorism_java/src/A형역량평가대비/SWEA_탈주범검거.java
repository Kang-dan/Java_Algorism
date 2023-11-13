package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_탈주범검거 {

	static int tCnt, N, M, R, C, L;
	static boolean[][] isVisit;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			isVisit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = bfs(R, C, L);//출발
			
			bw.write(String.format("#%d %d\n", test, result));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};
	private static int bfs(int r, int c, int l) {
		int time = 0;
		int resultCnt = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c}); //출발 
		isVisit[r][c] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size(); //큐 사이즈 
			if(time == L) return resultCnt;
			
			for(int i = 0; i < size; i++) {
				int v[] = q.poll();
				resultCnt++;
				
				int a = v[0];
				int b = v[1];
				int num = map[a][b];
				
				for(int d = 0; d < 4; d++) {
					int y = a + dr[d];
					int x = b + dc[d];
					if(y < 0 || y >= N || x < 0 || x >= M) continue; //배열범위 
					if(isVisit[y][x]) continue; //방문체크 
					if(map[y][x] == 0) continue;
					
					int num2 = map[y][x];
					//갈 수 있는지 확인하기 
					if(d == 0) { //오 
						if(((num == 1) ||(num == 3) ||(num == 4) ||(num == 5)) && ((num2 == 1) ||(num2 == 3) ||(num2 == 6) ||(num2 == 7))) {
							q.offer(new int[] {y, x});
							isVisit[y][x] = true;
							continue;
						}
					} else if(d == 1) { //아 
						if(((num == 1) ||(num == 2) ||(num == 5) ||(num == 6)) && ((num2 == 1) ||(num2 == 2) ||(num2 == 4) ||(num2 == 7))) {
							q.offer(new int[] {y, x});
							isVisit[y][x] = true;
							continue;
						}
						
					} else if(d == 2) { //왼 
						if(((num == 1) ||(num == 3) ||(num == 6) ||(num == 7)) && ((num2 == 1) ||(num2 == 3) ||(num2 == 4) ||(num2 == 5))) {
							q.offer(new int[] {y, x});
							isVisit[y][x] = true;
							continue;
						}
					} else if(d == 3) { //위 
						if(((num == 1) ||(num == 2) ||(num == 4) ||(num == 7)) && ((num2 == 1) ||(num2 == 2) ||(num2 == 5) ||(num2 == 6))) {
							q.offer(new int[] {y, x});
							isVisit[y][x] = true;
							continue;
						}
					}
				}
			}
			
			time++;
		}
		
		return resultCnt;
	}
}
