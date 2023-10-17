package BFSDFS;

import java.util.*;
import java.io.*;

public class BJ_2573_빙산 {

	static int N, M;
	static int[][] map;
	static int[][] newMap;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}s
		}
		
		int t = 0; //시간 
		while(true) {
			t++;
			
			//빙산 녹으러 감 
			time();
			
			//덩어리 개수 
			visit = new boolean[N][M]; //방문배열 초기화
			int iceCnt = 0; //초기화 
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < M-1; j++) {
					if(!visit[i][j] && map[i][j] > 0) {
						iceCnt++;
						if(iceCnt ==2) { //호출이 2번 이상되면 끝! 
							bw.write(t+"");
							bw.flush();
							System.exit(0);
						}
						bfs(i, j);
					}
				}
			}
			//만약 빙산 다 녹았으면 0 출력 
			if(iceCnt == 0) {
				bw.write(0+"");
				bw.flush();
				System.exit(0);
			}
		}
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};

	//빙산 덩어리 
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int v[] = q.poll();
			int a = v[0];
			int b = v[1];
			
			for(int d = 0; d < 4; d++) {
				int r = a + dr[d];
				int c = b + dc[d];
				if(visit[r][c] || map[r][c] <= 0) continue;
				if(map[r][c] > 0) {
					q.offer(new int[] {r, c});
					visit[r][c] = true;
				}
			}
		}
	}

	//빙산 녹이기 
	private static void time() {
		newMap = new int[N][M];
		
		//녹인값은 새로운 맵에 넣기 
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				
				if(map[i][j] != 0) { //섬이면 
					int sea = 0; //사방 바다개수 
					for(int d = 0; d < 4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						if(map[r][c] == 0) sea++;
					}
					
					int num = map[i][j] - sea;
					newMap[i][j] = (num <= 0) ? 0 : num;
				}
			}
		}
		
		//마지막에 기존 맵에 복사 
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}

}
