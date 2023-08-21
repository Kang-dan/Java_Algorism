package baekjoon;

import java.util.*;
import java.io.*;

public class baek_1245_G5_농장관리 {
	
	static int N, M;
	static int[][] map;
	static int[][] isVisit;
	static int cnt, minHeight;
	
	static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
	static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		isVisit = new int[N+2][M+2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(isVisit[i][j] != 1 && map[i][j] != 0) {
					bfs(i,j, map[i][j]);	
				}
			}
		}
		
		bw.write(cnt+"");
		
		bw.flush();
		
	}
	private static void bfs(int y, int x, int max) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean topFlag = true;
		q.offer(new int[] {y, x, max}); //인덱스 1,1 넣기 
		isVisit[y][x] = 1;
		
		while(!q.isEmpty()) {
//			int size = q.size();
//			
//			for (int i = 0; i < size; i++) {
				int[] v = q.poll();
				int a = v[0];
				int b = v[1];
				
				for(int d = 0; d < 8; d++) { //대각선도 확인해주기 
					if(map[a + dy[d]][b + dx[d]] > max) {
						topFlag = false; //이웃한 셀 중에 현재 셀보다 높은 곳이 있다면 최고점이 아님
					} else if(isVisit[a + dy[d]][b + dx[d]] != 1 && map[a + dy[d]][b + dx[d]] == max) {
						q.offer(new int[] {a + dy[d], b + dx[d]});
						isVisit[a + dy[d]][b + dx[d]] = 1;
					}
				}
//			}
		}
		if( topFlag && max > minHeight) cnt++; //최고점이며, 높이가 최소 높이보다 크다면 안전한 지역으로 간주하고 개수 증가
		
	}
	
	
}
