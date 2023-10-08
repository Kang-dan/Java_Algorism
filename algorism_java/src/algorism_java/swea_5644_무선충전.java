package algorism_java;

import java.util.*;
import java.io.*;

public class swea_5644_무선충전 {

	static int time, bcCnt; //이동시간, BC개수 
	static int[] A, B;
	static int[][] BC;
	
	static int[] dr = {0, -1, 0, 1, 0}; //0, 1, 2, 3, 4 (가만히, 상, 우 ,하, 좌)
	static int[] dc = {0, 0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			
			BC = new int[bcCnt][4];
			A = new int[time+1];
			B = new int[time+1];
			
			st = new StringTokenizer(br.readLine()); //A 이동정보 
			for(int i = 0; i < time; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < time; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				BC[i][0] = x;
				BC[i][1] = y;
				BC[i][2] = c;
				BC[i][3] = p;
			}
			
			// 출발할 때 처리해주기 
			int[] a = {1, 1}; // 출발 
			int[] b = {10, 10}; // 출발 
			
			//그담꺼 이어서 해주기 
			int result = 0;
			int sum;
			for(int i = 0; i <= time; i++) {
				int[] aa = new int[bcCnt];
				int[] bb = new int[bcCnt];
				//BC개수만큼 
				for(int j = 0; j < bcCnt; j++) {
					//A 처리 
					int y = Math.abs(a[0] - BC[j][1]);
					int x = Math.abs(a[1] - BC[j][0]);
					if(y+x <= BC[j][2]) {
						aa[j] = BC[j][3];
					}
					
					// B 처리 
					y = Math.abs(b[0] - BC[j][1]);
					x = Math.abs(b[1] - BC[j][0]);
					if(y+x <= BC[j][2]) {
						bb[j] = BC[j][3];
					}
				}
				
				sum = 0;
				for(int I = 0; I < bcCnt; I++) {
					for(int J = 0; J < bcCnt; J++) {
						if(I==J) {
							if(aa[I]!=0 && bb[J]!=0 && sum < aa[I]) {
								sum = aa[I];							
							} else if(aa[I]==0 && bb[J]!=0 && sum < bb[J]) {
								sum = bb[J];
							} else if(aa[I]!=0 && bb[J]==0 && sum < aa[I]) {
								sum = aa[I];
							}
						} else if(I!=J && sum < aa[I] + bb[J]) {
							sum = aa[I] + bb[J];
						}
					}
				}
				result += sum;
				
				a[0] += dr[A[i]];
				a[1] += dc[A[i]];
				b[0] += dr[B[i]];
				b[1] += dc[B[i]];
			}
			
			bw.write(String.format("#%d %d\n", test, result));
		}
		
		bw.flush();
	}
}
