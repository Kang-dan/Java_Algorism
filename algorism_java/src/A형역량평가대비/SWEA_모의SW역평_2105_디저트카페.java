package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_모의SW역평_2105_디저트카페 {

	static int N;
	static int resultMax, resultCnt;
	static int[][] map;
	static boolean[] desert; //디저트종류 체크 
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			resultMax = 0;
			resultCnt = -1; // 초기값 (디저트 먹을 수 없으면 그대로 출력)
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			desert = new boolean[101]; //디저트 종 (1~100)
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					//경우 1
					for(int a = 2; a <= N-1; a++) { //한 변의 길이 선택 
						for(int b = 2; b <= N-a+1; b++) { //나머지 한 변의 길이 선택 
							사방돌고오기(i, j, a, b); //시작 인덱스, 변의 길이 두가지 
						}
					}
					
					//경우 2 (위와 변의 길이가 서로 반대)
					for(int a = 2; a <= N-1; a++) {
						for(int b = 2; b <= N-a+1; b++) { 
							사방돌고오기(i, j, b, a); //변의 길이 두가지를 반대로 보내주기 
						}
					}
				}
			}
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//대각선 방향 
	static int[] dy = {1, 1, -1, -1};
	static int[] dx = {1, -1, -1, 1};
	
	private static void 사방돌고오기(int y, int x, int one, int two) throws IOException {
//		desert = new boolean[101]; //디저트종류 체크 배열 초기화 
		Arrays.fill(desert, false); //배열 초기화 
		int sum = 0;
		
		//다른방향 가기전 꼭지점의 인덱스 저장하기 위한 변수 
		int a = 0, b = 0;
		int a1 = 0, b1 = 0;
		int a2 = 0, b2 = 0;
		int a3 = 0, b3 = 0;
		
		 //1. 오른쪽 아래 방향 
		for(int i = 1; i < one; i++) {
			if(y + i*dy[0] < 0 || y + i*dy[0] >= N || x + i*dx[0] < 0 || x + i*dx[0] >= N) return; //배열범위 넘으면 리턴 
			if( desert [ map[y + i*dy[0]][x + i*dx[0]] ] == true) return; //디저트 종류 겹치면 리턴 
			sum += map[y + i*dy[0]][x + i*dx[0]];
			desert[ map[y + i*dy[0]][x + i*dx[0]] ] = true; //디저트 종류 방문 체크 
			a = y + i*dy[0];
			b = x + i*dx[0];
		}
		
		//2. 왼쪽 아래 방향 
		for(int i = 1; i < two; i++) {
			if(a + i*dy[1] < 0 || a + i*dy[1] >= N || b + i*dx[1] < 0 || b + i*dx[1] >= N) return; //배열범위 넘어감 
			if( desert [ map[a + i*dy[1]][b + i*dx[1]] ] == true) return; 
			sum += map[a + i*dy[1]][b + i*dx[1]];
			desert[ map[a + i*dy[1]][b + i*dx[1]] ] = true;
			a1 = a + i*dy[1];
			b1 = b + i*dx[1];
		}
		
		//3. 왼쪽 위 방향 (1.번과 같은 길이)
		for(int i = 1; i < one; i++) {
			if(a1 + i*dy[2] < 0 || a1 + i*dy[2] >= N || b1 + i*dx[2] < 0 || b1 + i*dx[2] >= N) return; //배열범위 넘어감 
			if( desert [ map[a1 + i*dy[2]][b1 + i*dx[2]] ] == true) return;
			sum += map[a1 + i*dy[2]][b1 + i*dx[2]];
			desert[ map[a1 + i*dy[2]][b1 + i*dx[2]] ] = true;
			a2 = a1 + i*dy[2];
			b2 = b1 + i*dx[2];
		}
		
		//4. 오른쪽 위 방향 (2.번과 같은 길이)
		for(int i = 1; i < two; i++) {
			if(a2 + i*dy[3] < 0 || a2 + i*dy[3] >= N || b2 + i*dx[3] < 0 || b2 + i*dx[3] >= N) return; //배열범위 넘어감 
			if( desert [ map[a2 + i*dy[3]][b2 + i*dx[3]] ] == true) return;
			sum += map[a2 + i*dy[3]][b2 + i*dx[3]];
			desert[ map[a2 + i*dy[3]][b2 + i*dx[3]] ] = true;
			a3 = a2 + i *dy[3];
			b3 = b2 + i *dx[3];
		}
		
		//한바퀴 돌고 첫 지점과 끝지점이 동일한지 확인
		if(a3 != y || b3 != x) return;
		
		if(sum > resultMax) {
			resultCnt = 0;
			resultMax = sum;
			for(int i = 0; i < 101; i++) {
				if(desert[i]) resultCnt++;
			}
		}
//		
		//확인용 (테케 제대로 나옴)
//		bw.write("sum="+sum+" ");
//		for(int i = 0; i <101; i++) {
//			if(desert[i] == true)
//			bw.write(i+":"+desert[i]+" ");
//		}
//		bw.write("\n");
		
	}


}
