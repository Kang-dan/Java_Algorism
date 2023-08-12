package baekjoon;

import java.util.*;
import java.io.*;

public class baek_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int numCnt = Integer.parseInt(st.nextToken()); //수의 개수 
		int sumCnt = Integer.parseInt(st.nextToken()); //구해야하는 합의 개수 
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[numCnt+1];
		for(int i = 1; i <= numCnt; i++) num[i] = Integer.parseInt(st.nextToken());
		
		//누적 합 배열 (시간초과 방지) 
		int[] doubleSum = new int[numCnt+1];
		for(int i = 1; i <= numCnt; i++) doubleSum[i] = doubleSum[i-1] + num[i];
		
		//범위 
		for(int i = 0; i < sumCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int startEndSum = doubleSum[end] - doubleSum[start-1];
			bw.write(startEndSum+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
