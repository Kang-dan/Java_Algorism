/*
 * 2차원 배열 구간합 구하기 
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());
		int[][] map = new int[size+1][size+1]; //입력 배열 
		int[][] doubleSumMap = new int[size+1][size+1]; //누적합 배열 
		
		for(int i = 1; i <= size; i ++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //입력 배열 
				doubleSumMap[i][j] = doubleSumMap[i][j-1] + map[i][j]; //누적합 배열 
			}
		}
		
		for(int i = 0; i < sumCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			int i1 = Integer.parseInt(st.nextToken());
			int j1 = Integer.parseInt(st.nextToken());
			
			int i2 = Integer.parseInt(st.nextToken());
			int j2 = Integer.parseInt(st.nextToken());
				
			int resultSum = 0;
			for(int d = i2; d >= i1; d--) { // 가로줄 하나씩 구하려고 
				resultSum += doubleSumMap[d][j2] - doubleSumMap[d][j1-1];
			}
			
			bw.write(resultSum+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
