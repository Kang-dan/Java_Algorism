package baekjoon;

import java.util.*;
import java.io.*;

public class study_BJ_17406_배열돌리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int sizeY = Integer.parseInt(st.nextToken());
		int sizeX = Integer.parseInt(st.nextToken());
		int rotate =  Integer.parseInt(st.nextToken());
		
		int[][] map =  new int[sizeY+1][sizeX+1];
		for(int i = 1; i <= sizeY; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= sizeX; i++) {
				map[i][j] = Inte
			}
		}
		
	}
}
