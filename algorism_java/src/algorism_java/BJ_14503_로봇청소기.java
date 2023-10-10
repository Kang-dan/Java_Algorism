package algorism_java;

import java.util.*;
import java.io.*;

public class BJ_14503_로봇청소기 {

	static int N, M, robotR, robotC, robotP, resultCnt;
	static int[][] map;
	static int[] point = {0, 1, 2, 3}; //북, 동, 남 서 
	
	static int[] dr = {-1, 0, 1, 0}; //북 동 남 서 
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		robotR = Integer.parseInt(st.nextToken());
		robotC = Integer.parseInt(st.nextToken());
		robotP = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go();
		
		bw.write(resultCnt + "");
		bw.flush();
		
	}
	
	private static void go() {
		while(true) {
			//현재 칸 청소 (1번) 
			if(map[robotR][robotC] == 0) {
				map[robotR][robotC] = 2;
				resultCnt++;
			}
			//주변 4칸 청소되지 않은 빈칸이 없는 경우 
			int cnt = 0;
			for(int d = 0; d < 4; d++) {
				int r = robotR + dr[d];
				int c = robotC + dc[d];
				if(map[r][c] != 0) cnt++;
				//주변 4칸 중 청소되닞 않은 빈 칸이 있는 경우 
				if(map[r][c] == 0) {
					robotP = (robotP + 7) % 4; //반시계 방향으로 90도 회전 
					if(map[robotR + dr[robotP]][robotC + dc[robotP]] == 0) {
						robotR = robotR + dr[robotP];
						robotC = robotC + dc[robotP];
						break;
					}
				}
				if(cnt == 4) {
					//후진할 수 있다면 후진하고 1번으로 돌아가기 
					// 후진방향 (robotP + 2) % 4;
					if(map[robotR + dr[(robotP + 2) % 4]][robotC + dc[(robotP + 2) % 4]] != 1) {
						robotR = robotR + dr[(robotP + 2) % 4];
						robotC = robotC + dc[(robotP + 2) % 4];
					} else return;
				}
			}
			if(cnt != 4) continue;
		}
	}

}
