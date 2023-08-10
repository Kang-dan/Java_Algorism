package baekjoon;

import java.util.*;
import java.io.*;

public class baek_16926_S1_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); //회전 수
		
		//배열 입력
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {0, 1, 0, -1}; //오 아 왼 위 
		int[] dc = {1, 0, -1, 0};

		
		//회전수만큼 
		R %= (2*(N+M)-4); //이렇게 반복되는 회전수를 줄이면 왜 안돼??
		for(int i = 0; i < R; i++) {
			int loopCnt = Math.min(N, M)/2; //네모 안에 네모 수 만큼 반복 
			for(int j = 0; j < loopCnt; j++) {
				int r = j; //0
				int c = j; //0
				int temp = arr[j][j]; //시작점 
				for(int d = 0; d < 4; d++) {
					while(true) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < j || nr >= N-j || nc < j || nc >= M-j) break;
						arr[r][c] = arr[nr][nc];
						r = nr;
						c = nc;
					}
				}
				arr[j+1][j] = temp; //마지막 들어가는 수 
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	

}
