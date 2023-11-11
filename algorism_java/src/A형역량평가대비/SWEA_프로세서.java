package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_프로세서 {

	static int tCnt, N;
	static int coreMax = 0, lineMin = 0;
	static int[][] map;
	static List<int[]> coreList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i == 0 || j == 0 || i == N-1 || j == N-1)) {
						continue; //가장자리 코어
					}
					if(map[i][j] == 1) {
						coreList.add(new int[] {i, j}); //코어 좌표 
						
					}
				}
			}
			
			lineMin = Integer.MAX_VALUE;
			coreMax = Integer.MIN_VALUE;
			
			dfs(0, 0, 0); //좌표개수, 코어개수, 전선길이 
			
			bw.write(String.format("#%d %d\n", test, lineMin));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
	static int[] dc = {1, 0, -1, 0};
	
	public static void dfs(int idx, int coreCnt, int lineLength) {
		if(coreList.size() == idx) { //더이상 뺄 코어가 없으면 
			//코어 개수 
			if(coreCnt > coreMax) {
				coreMax = coreCnt;
				lineMin = lineLength;
			} else if(coreCnt == coreMax) { //코어개수 같으면 
				if(lineMin > lineLength) {
					lineMin = lineLength; //전선길이 더 짧은 거로 
				}
			}
			return;
		}
		
		int[] v = coreList.get(idx);
		int y = v[0];
		int x = v[1];
		
		for(int d = 0; d < 4; d++) {
			int count = 0, nr = v[0], nc = v[1];
			
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				//범위 체크  & 코어 & 전선 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
				
				if(map[nr][nc] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			
			int fill_x = x;
			int fill_y = y;
			
			//카운트 개수만큼 1로 채우기 
			for(int i = 0; i < count; i++) {
				fill_y += dr[d];
				fill_x += dc[d];
				map[fill_y][fill_x] = 1;
			}
			
			if(count == 0) dfs(idx+1, coreCnt, lineLength);
			else  {
				dfs(idx+1, coreCnt + 1, lineLength + count);
				
				fill_y = y;
				fill_x = x;
				
				//원본 맵 다시 0으로 되돌리기 
				for(int i = 0; i < count; i++) {
					fill_y += dr[d];
					fill_x += dc[d];
					map[fill_y][fill_x] = 0;
				}
			}
		}
	}

}
