package algorism_java;

import java.util.*;
import java.io.*;

public class BJ_2206_벽부수고이동하기 {

	static int N, M, resultCnt;
	static int[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String v = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = v.charAt(j) - '0';
			}
		}
		
		bw.write(bfs()+"");
		bw.flush();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};
	
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] v = q.poll();
				int y = v[0];
				int x = v[1];
				int wCnt = v[2]; //벽 부순 횟수 
				
				if(y == N-1 && x == M-1) return ++resultCnt;
				
				for(int d = 0; d < 4; d++) {
					int a = y + dr[d];
					int b = x + dc[d];
					if(a < 0 || a >= N || b < 0 || b >= M) continue;
//					if(visit[a][b][wCnt]) continue;
					
					if(!visit[a][b][wCnt] && map[a][b] == 0) {
						visit[a][b][wCnt] = true;
						q.offer(new int[] {a, b, wCnt});
					}
					
					if(!visit[a][b][1] && map[a][b] == 1 && wCnt == 0) {
						wCnt++;
						visit[a][b][wCnt] = true;
						q.offer(new int[] {a, b, wCnt});
					}
				}
			}
			resultCnt++;
		}
		return -1;
	}
	
	

}
