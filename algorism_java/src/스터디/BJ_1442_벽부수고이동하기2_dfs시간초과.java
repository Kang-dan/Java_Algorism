/*
 * dfs로 풀었다가 테케는 맞고, 시간초과남.
 */
package 스터디;

import java.util.*;
import java.io.*;

public class BJ_1442_벽부수고이동하기2_dfs시간초과{

	static int N, M, K;
	static int resultCnt;
	static int[][] map;
	static boolean[][] isVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		isVisit = new boolean[N+1][M+1];
		resultCnt = Integer.MAX_VALUE;
		dfs(1, 1, 0, K);//출발y,출발x, 이동수, 벽 부수기 남은 수
		
		if(resultCnt == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(resultCnt+"");
		
		bw.flush();	
	}
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	private static void dfs(int y, int x, int move, int cnt) {
		if(move >= resultCnt) return;
		//도착했으면 최소값 갱신 및 리턴 
		if(y == N && x == M) {
			move++;
			resultCnt = Math.min(resultCnt, move);
			return;
		}
				
		//도착안했는데 주변이 다 벽이고, 부술 수 있는 횟수가 안남은 경우 리턴 
		for(int d = 0; d < 4; d++) {
			if(move >= resultCnt) return;
			if(y + dy[d] < 1 || y + dy[d] > N || x + dx[d] < 1 || x + dx[d] > M) continue;
			if(isVisit[y + dy[d]][x + dx[d]]) continue;
			
			//일반 길인 경우
			if(move >= resultCnt) return;
			if(!isVisit[y + dy[d]][x + dx[d]] && map[y + dy[d]][x + dx[d]] == 0) {
				isVisit[y + dy[d]][x + dx[d]] = true;
				dfs(y + dy[d], x + dx[d], move + 1, cnt); 
			}
			
			if(move >= resultCnt) return;
			//벽이고, 횟수 남아있는 경우
			if(!isVisit[y + dy[d]][x + dx[d]] && map[y + dy[d]][x + dx[d]] == 1 && cnt > 0) {
				isVisit[y + dy[d]][x + dx[d]] = true;
				dfs(y + dy[d], x + dx[d], move + 1, cnt - 1);
			}
		}
		
		isVisit[y][x] = false;
		return;
		
	}
	<link rel="stylesheet" href="css/main.css" />
	  </head>
	
	
	

}
