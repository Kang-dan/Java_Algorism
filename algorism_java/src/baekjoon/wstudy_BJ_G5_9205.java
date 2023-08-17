package baekjoon;

import java.util.*;
import java.io.*;

public class wstudy_BJ_G5_9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//입력 
		int testCnt = Integer.parseInt(br.readLine()); //테스트 수 
		for(int test = 0; test < testCnt; test++) {
			int[][] map = new int[70000][70000]; // 맵 생성 (-32768 ≤ x, y ≤ 32767)범위 고려 
			
			int gsCnt = Integer.parseInt(br.readLine()); //편의점 수 
			
			st = new StringTokenizer(br.readLine()); //상근이집 위치 1로 체크 
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			
			for(int i = 0; i < gsCnt; i++) { 
				st = new StringTokenizer(br.readLine()); //편의점 위치 2로 체크 
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[x][y] = 2;
			}
			
			st = new StringTokenizer(br.readLine()); //락페 위치 -1로 체크 
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = -1;
			
			//과정 
			/*
			 * 편의점 들리면 맥주는 20개로 초기화 
			 * 
			 */
			
			
		}
	}
}
