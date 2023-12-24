package baekjoon;

import java.util.*;
import java.io.*;

public class baek_1932_정수삼각형 {

	static int n, resultMax;
	static int[][] map;
	static int[][] newMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		newMap = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		resultMax = newMap[0][0] = map[0][0];
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j <= i; j++) {
				newMap[i+1][j] = (newMap[i+1][j] <= map[i+1][j] + newMap[i][j])? map[i+1][j] + newMap[i][j] : newMap[i+1][j];
				resultMax = Math.max(newMap[i+1][j], resultMax);
				newMap[i+1][j+1] = (newMap[i+1][j+1] <= map[i+1][j+1] + newMap[i][j])? map[i+1][j+1] + newMap[i][j] : newMap[i+1][j+1];
				resultMax = Math.max(newMap[i+1][j+1], resultMax);
			}
		}
		
		System.out.println(resultMax);
	}

}
