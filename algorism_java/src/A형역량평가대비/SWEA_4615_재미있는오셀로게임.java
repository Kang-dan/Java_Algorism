package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_4615_재미있는오셀로게임 {

	static int tCnt, N, bCnt, wCnt; //흑돌은 1, 백돌은 2
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new int[N+2][N+2];
			int mid = N/2;
			map[mid][mid] = 2; //흰 
			map[mid+1][mid+1] = 2; //흰  
			map[mid][mid+1] = 1; //검 
			map[mid+1][mid] = 1; //검 
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				
				map[b][a] = color;
				
				int y = b;
				int x = a;
				for(int d = 0; d < 8; d++) {
					y = y + dr[d];
					x = x + dc[d];
					go(y, x, color, d);
					y = b;
					x = a;
				}
			}
			
			//마지막 개수 확인 
			bCnt = 0;
			wCnt = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][j] == 1) {
						bCnt++;
					} else if(map[i][j] == 2) {
						wCnt++;
					}
				}
			}
			
			bw.write(String.format("#%d %d %d\n", test, bCnt, wCnt));
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
	static int[] dr = {0, 1, 0, -1, -1, 1, 1, -1}; // 오 아 왼 위 , 대각선 
	static int[] dc = {1, 0, -1, 0, 1, 1, -1, -1};
	private static void go(int i, int j, int color, int d) {
		int cnt = 0; //이동횟수 
		//벽 만나면 끝남 
		if(i <= 0 || i > N || j <= 0 || j > N) return;
		
		//만약 빈공백 만나면 넘어감 
		if(map[i][j] == 0) return;
		
		//만약 나랑 같은 색이면 넘어감 
		if(map[i][j] == color) return;
		
		//만약 나랑 다른 색 만날때까지 같은 색 만나면 바꿔줌
		int a = i;
		int b = j;
		while(map[i][j] != color) {
			a += dr[d];
			b += dc[d];
			cnt++;
			if(a <= 0 || a > N || b <= 0 || b > N) { //범위 넘어가면 
				return;
			}
			
			if(map[a][b] == 0) return;
			
			if(map[a][b] == color) {
				map[i][j] = color;
				for(int k = 0; k < cnt; k++) {
					map[i][j] = color;
					i += dr[d];
					j += dc[d];
				}
				return;
			}
	
			
		}
		
	}

}
