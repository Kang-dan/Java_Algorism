package algorism_java;

import java.util.*;
import java.io.*;

public class swea_5656_모의SW_벽돌깨기 {
	static int n, w, h;
	static int resultMax;
	static int[][] map;
	static boolean[][] visit;
	
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visit = new boolean[h][w];
			q = new ArrayDeque<>();
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i == 0 && map[i][j] != 0) || (i - 1 >= 0 && map[i][j] != 0 && map[i-1][j] == 0)) {
						q.offer(new int[]{i, j});
					}
				}
			}
			
			//맨 위의 숫자 갯수만큼 bfs돌리기 // 이 중 최고의 수만큼 
			resultMax = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				visit = new boolean[h][w];
				int[] v = q.poll();
				bfs(v[0], v[1], map, visit, 0);
			}
		
			bw.write(String.format("#%d %d\n", test, resultMax));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dy = {0, 1, 0, -1}; // 오, 아, 왼, 위
	static int[] dx = {1, 0, -1, 0};
	
	private static void bfs(int i, int j, int[][] map1, boolean[][] visit1, int cnt) {
		if(cnt == n) {
			count(map1);
			return;
		}
		
		Queue<int[]> qu = new ArrayDeque<>();
		qu.offer(new int[] {i, j});
		visit1[i][j] = true;
		
		while(!qu.isEmpty()) {
			int[] v = qu.poll();
			int y = v[0];
			int x = v[1];
			int size = map1[y][x]; // 범위
			
			for(int s = 0; s < size-1; s++) {
				for(int d = 0; d < 4; d++) {
					int a = i + dy[d];
					int b = j + dx[d];
					if(a < 0 || a >= h || b < 0 || b >= w) continue;
					if(visit1[a][b]) continue;
					if(map1[a][b] != 0) {
						qu.offer(new int[] {a, b});
						visit1[a][b] = true;
					}
				}
			}
			
		}
		
		//빈공간 이동
		int[][] map2 = new int[h][w];
		int sum;
		for(int W = 0; W < w; W++) {
			sum = h-1;
			for(int H = h-1; H >= 0; H--) {
				if(visit1[H][W] && map1[H][W] != 0) {
					map2[sum--][W] = map1[H][W];
				}
			}
		}
		

		for(int y = 0;  y < h; y++) {
			for(int x = 0; x < w; x++) {
				if((y == 0 && map2[y][x] != 0) || (y - 1 >= 0 && map2[y][x] != 0 && map2[y-1][x] == 0)) {
					boolean[][] visit2 = new boolean[h][w];
					bfs(y, x, map2, visit2, cnt+1);
				}
			}
		}		
		
	}

	private static void count(int[][] map1) {
		int sum = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map1[i][j] != 0) sum++;
			}
		}
		
		if(resultMax > sum) resultMax = sum;
	}

}