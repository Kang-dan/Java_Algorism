/*
 * dfs + 백트래킹 
 */
package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_SWTest샘플문제_1767_프로세서연결하기 {
	
	static class Core {
		int x, y;
		
		public Core(int y, int x){
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int minLength, maxCore;
	static int[][] map;
	static boolean[][] isVisit;
	static List<Core> coreList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			//입력 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(i == 0 || j == 0 || i == N-1 || j == N-1) continue; //끝자리에 있다면 
					if(map[i][j] == 1) coreList.add(new Core(i, j)); //프로세서 좌표 넣기 
				}
			}
			
			minLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			dfs(0, 0, 0); //현재 위치, 코어개수, 현재 전선길이 합 
			
			bw.write(String.format("#%d %d\n", test, minLength));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dy = {0, 1, 0, -1}; //오 아 왼 위
	static int[] dx = {1, 0, -1, 0};
	
	private static void dfs(int idx, int coreCnt, int wireCnt) {
		if(idx == coreList.size()) {
			if(maxCore < coreCnt) { 
				maxCore = coreCnt;
				minLength = wireCnt;
			} else if(maxCore == coreCnt) {
				minLength = Math.min(wireCnt, minLength);
			}
			return;
		}
		
		//인덱스 위치의 코어의 좌표
		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;
		
		//상 하 좌 우 탐색 
		for(int d = 0; d < 4; d++) {
			int count = 0, nx = x, ny = y;
			
			while(true) {
				nx += dx[d]; //한 방향으로 계속 이동 
				ny += dy[d];
				
				//범위를 벗어나거나 다른 코어나 전선을 만나지 않으면
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) break;
				
				//가는 길에 다른 코어나 전선이 존재하면 다른 방향으로!
				if(map[ny][nx] == 1) {
					count = 0;
					break;
				}
				
				// 가는데 성공하면 +1
				count++;
			}
			
			//카운트 개수만큼 1로 채우기 
			int fill_x = x;
			int fill_y = y;
			
			for(int i = 0; i < count; i++) {
				fill_x += dx[d];
				fill_y += dy[d];
				map[fill_y][fill_x] = 1; // 카운트 수만큼 채우기 
			}
			
			if(count == 0) dfs(idx + 1, coreCnt, wireCnt);
			else {
				dfs(idx + 1, coreCnt + 1, wireCnt + count);
				
				//원본 맵을 다시 0으로 되돌리기
				fill_x = x;
				fill_y = y;
				
				for(int i = 0; i < count; i++) {
					fill_x += dx[d];
					fill_y += dy[d];
					map[fill_y][fill_x] = 0;
				}
			}
			
		}
		
	}

}
