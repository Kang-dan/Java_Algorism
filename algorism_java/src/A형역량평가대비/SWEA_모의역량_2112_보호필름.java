package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_모의역량_2112_보호필름 {

	static int D, W, K, resultCnt;
	static boolean check;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			
			select = new int[D];	
			Arrays.fill(select, -1);
			visit = new boolean[D];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			check = false;
			resultCnt = 0;
			for(int i = 0; i < D; i++) {
				check(i, 0, 0); // 바꾸는 개수
				if(check == true) {
					resultCnt = i;
					break;
				}
			}
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] select;
	private static void check(int change, int cnt, int start) {
		if(cnt == change) {
			// 모두 통과하는지 확인하기 
			check2(change, select, map);
			//모두 통과한다면 바로 리턴해주기 
			if(check == true) return;
			return;
		}
		for(int i = start; i < D; i++) {
			select[cnt] = i;
			check(change, cnt + 1, i + 1);
			//모두 통과한다면 바로 리턴하기 
			if(check == true) return;
		}
	}
	
	static boolean[] visit;
	private static void check2(int change, int[] select2, int[][] map1) {
		
		for(int i = 0; i < D; i++) {
			if(select2[i] != -1 && !visit[i]) {
				//가로줄을 0으로
				visit[i] = true;
				Arrays.fill(map1[select2[i]], 0);
				check2(change, select2, map1);
				visit[i] = false;
				//세로줄 확인하기 
				
				
				//가로줄을 1로 
				visit[i] = true;
				Arrays.fill(map1[select2[i]], 1);
				check2(change, select2, map1);
				visit[i] = false;
				//세로줄 확인하기 
			}
		}
		
		//만약 통과한 개수가 W와 다르면 check false
		int cnt0;
		int cnt1;
		int rCnt = 0;
		for(int i = 0; i < W; i++) {
			cnt0 = 0; cnt1 = 0;
			for(int j = 0; j < D; j++) {
				if(map[j][i] == 0) {
					cnt0++;
					cnt1 = 0;
				}
				if(map[j][i] == 1) {
					cnt1++;
					cnt0 = 0;
				}
				
				if(cnt0 >= K || cnt1 >= K) {
					rCnt++;
					break;
				}
			}
			if(rCnt != i+1) {
				check = false;
				return;
			}
		}
		check = true;
		
		for(int i = 0; i < D; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		return;
	}

}
