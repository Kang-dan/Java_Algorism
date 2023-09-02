/*
 * bfs + 레벨별탐색 (매개변수 : 현재위치 행, 현재위치 열, 벽부수기 가능한 남은 횟수)
 * 방문처리를 어떻게 할 것인가!가 핵심 문제.
 * 
 * 예) 방문처리를 2차원 배열 한개로 할 경우 반례
 * 2 4 2
 * 0110
 * 0110
 */
package 스터디;

import java.util.*;
import java.io.*;

public class BJ_1442_벽부수고이동하기2_bfs레벨별탐색 {

	static int N, M, K; //행 열 부술수 있는 횟수 
	static int resultCnt; //이동횟수 결과 
	static int[][] map; //입력받을 배열 
	static boolean[][][] isVisit; //방문체크 배열 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//입력 
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
		
		//풀이 
		isVisit = new boolean[N+1][M+1][K+2]; //벽을 부순 횟수대로 방문체크 
		resultCnt = Integer.MAX_VALUE;
		bfs(1, 1, K);//출발y,출발x, 이동수, 벽 부수기 남은 수
		
		//출력 
		if(resultCnt == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(resultCnt+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	private static void bfs(int a, int b, int Kcnt) {		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a, b, Kcnt});
		isVisit[a][b][0] = true;
		
		int move = 1; //출발 이동횟수 초기값 
		while(!q.isEmpty()) {
			int size = q.size();
			
			//레벨별 탐색 
			for(int i = 0; i < size; i++) {
				int[] v = q.poll();
				int y = v[0];
				int x = v[1];
				int cnt = v[2]; //벽부술 수 있는 횟수 
				int breakWall = K - cnt; //현재까지 부순 벽의 수 
							
				//도착지점에 첫번째로 도달하면 그게 최단거리!
				if(y == N && x == M) {
					resultCnt = move;
					return;
				}
				
				//4방향(오, 아, 왼, 위)
				for(int d = 0; d < 4; d++) {				
					if(y + dy[d] < 1 || y + dy[d] > N || x + dx[d] < 1 || x + dx[d] > M) continue; //배열범위 체크					
					
					//일반 길인 경우
					if(!isVisit[y + dy[d]][x + dx[d]][breakWall] && map[y + dy[d]][x + dx[d]] == 0) {
						isVisit[y + dy[d]][x + dx[d]][breakWall] = true;
						q.offer(new int[] {y + dy[d], x + dx[d], cnt});
					}
					
					//벽이고, 횟수 남아있는 경우 -> 부술수 있는 횟수하나 줄이고 큐에 넣기 
					if(!isVisit[y + dy[d]][x + dx[d]][breakWall + 1] && map[y + dy[d]][x + dx[d]] == 1 && cnt > 0) {
						isVisit[y + dy[d]][x + dx[d]][breakWall + 1] = true;
						q.offer(new int[] {y + dy[d], x + dx[d], cnt-1});
					}
					
				}
			}
			
			move++;
		}
	}
}