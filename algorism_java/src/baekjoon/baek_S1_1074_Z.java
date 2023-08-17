package baekjoon;

import java.util.*;
import java.io.*;

public class baek_S1_1074_Z {

	static int N, r, c;
//	static int[][] map;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		N = (int) Math.pow(2, N);
		
//		map = new int[N][N]; //인덱스 1부터 시작할거 
		
		int result = Z(0, 0, N); //시작인덱스, 크기 
		
		bw.write(result+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int Z(int i, int j, int size) {
		if(size == 1) {
//			map[i][j] = cnt++;
			return 0;
		}
		
		if(r < i + size/2 && c < j + size/2) 
			return Z(i, j, size/2);
		else if(r < i + size/2 && c < j + size) 
			return Z(i, j+size/2, size/2) + (int) Math.pow(size / 2, 2);
		else if(r < i + size && c < j + size/2)
			return Z(i+size/2, j, size/2) + (int) Math.pow(size / 2, 2)*2;
		else
			return Z(i+size/2, j+size/2, size/2) + (int) Math.pow(size / 2, 2)*3;
		
	}

}