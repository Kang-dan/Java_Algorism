package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_모의SW역평_5644_무선충전 {

	static int M, A; //총 이동시간, BC개수 
	static int[] a, b; // a,b 이동경로
	static int[][] BC;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			map = new int[10][10]; //맵 크기 고정 
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			a = new int[M];
			b = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) b[i] = Integer.parseInt(st.nextToken());
			
			BC = new int[A+1][4]; // 1~A번까지 
			
			//BC정보 입력 
			for(int i = 1; i <= A; i++) {
				st = new StringTokenizer(br.readLine()); //BC좌표, 충전범위, 처리량 
				BC[i][0] = Integer.parseInt(st.nextToken()); //BC x좌표 
				BC[i][1] = Integer.parseInt(st.nextToken()); //BC y좌
				BC[i][2] = Integer.parseInt(st.nextToken()); //충전범위
				BC[i][3] = Integer.parseInt(st.nextToken()); //처리량 
			}
			
			//기존 맵에 지도 칠하기 
			for(int i = 0; i < )
			
		}
	}

}
