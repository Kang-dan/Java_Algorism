/*
 * 일반 bfs로는
 * 123
 * 654
 * 789
 * 이런경우 최악의 시간복잡도
 * 확인 배열 하나 만들어서 시간줄이기!
 */
package algorism_java;

import java.util.*;
import java.io.*;

public class 스터디_SWEA_정사각형방_시간줄이기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int testCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= testCnt; test++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] check = new int[size * size + 1]; //1부터~
			//사방탐색
			int[] y = {0, 1, 0, -1}; //오 아 왼 위 
			int[] x = {1, 0, -1, 0};
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					for(int d = 0; d < 4; d++) {
						if(0 <= i + y[d] && i + y[d] < size && 0 <= j + x[d] && j + x[d] < size) {
							if(map[i][j] + 1 == map[i + y[d]][j + x[d]]) check[map[i][j]] = 1;
						}
					}
				}
			}
			
			int room = 1;
			int cnt = 1; //자기 방도 들어간 거로 하기 때문에 1이 초기값 
			int max = -1;
			for(int i = size * size; i >= 1; i--) {
				if(check[i] == 0) {
					cnt = 1;
					continue;
				}
				cnt++;
				
				if(cnt >= max) {
					max = cnt;
					room = i;
				}				
			}
			
			bw.write(String.format("#%d %d %d\n", test, room, max));			
		}
		
		bw.flush();
		bw.close();
	}

}
