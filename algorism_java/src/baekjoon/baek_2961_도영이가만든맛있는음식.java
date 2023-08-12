/*
 * 부분집합바이너리 카운팅 이용 (모든 경우의 수를 확인)
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_2961_도영이가만든맛있는음식 {
	
	static int foodCnt;
	static int[][] food;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		foodCnt = Integer.parseInt(br.readLine());
		food = new int[foodCnt][2];
		for(int i = 0; i < foodCnt; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(부분집합바이너리카운팅()+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int 부분집합바이너리카운팅() {
		int min = Integer.MAX_VALUE; //신맛 쓴맛 차이가 최소가 되도록  
		for(int i = 1; i < Math.pow(2,foodCnt); i++) {
			int sFoodMul = 1; //신맛 곱 
			int dFoodSum = 0; //쓴맛 합 
			for(int j = 0; j < foodCnt; j++) {
				if((i & (1 << j)) != 0) {
					sFoodMul *= food[j][0];
					dFoodSum += food[j][1];
				}
			}
			if(min > Math.abs(sFoodMul - dFoodSum)) min = Math.abs(sFoodMul - dFoodSum);
		}
		return min;
	}
}
