package A형역량평가대비;

import java.util.*;
import java.io.*;
// 점수 : 벽이나 블록에 부딪힌 횟수
// 게임 끝 : 핀볼이 출발위치로 돌아옴, 블랙홀에 빠질 때 
// 게임에서 얻을 수 있는 점수의 최댓값(0인 부분에서 출발 다 해보기) 해서 최댓값)
public class SWEA_5650_핀볼게임 {

	static int tCnt, N, maxCnt;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tCnt =  Integer.parseInt(br.readLine().trim());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						for(int d = 0; d < 4; d++) {
							map[i][j] = -1;
							go(i, j, d); //출발 위치, 	방향 
							map[i][j] = 0;
						}
					}
				}
			}
			
			bw.write(String.format("#%d %d\n", test, maxCnt));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dr = {-1, 0, 1, 0}; //상 좌 하 우 (+2하고 모듈러해주면 반대방향)
	static int[] dc = {0, -1, 0, 1};
	
	private static void go(int i, int j, int d) {
		int cnt = 0;
		int y = i, x = j;
		while(true) {
			y =  y + dr[d];
			x = x + dc[d];
			//만약 벽을 만났으면 
			if(y < 0 || y >= N || x < 0 || x >= N) {
				cnt++;
				//반대 방향으로 
				d = (d+2) % 4;
				continue;
			}
			
			//블랙홀을 만나면 (또는 시작지점) 
			if(map[y][x] == -1) {
				maxCnt = Math.max(cnt, maxCnt);
				return;
			}
			//static int[] dr = {-1, 0, 1, 0}; //상 좌 하 우 
			//블록을 만났으면 (1~5)
			if(1<= map[y][x] && map[y][x] <= 5) {
				cnt++;
				//방향 바꾸기 
				int n = map[y][x];
				if(d == 0) { // 상 
					if(n==1 ||n==4 || n==5) {
						d = (d+2) % 4;  //반대로 
					} else if(n==2) {
						d = 3; //오른쪽으로  
					} else if( n == 3) {
						d = 1;  //왼쪽으로 
					}
				} else if(d ==1) { // 좌 
					if(n==1) {
						d = 0; //위로 
					} else if(n == 2) {
						d = 2; //아래로 
					} else if( n == 3 || n==4 || n==5) {
						d = (d+2) % 4; //반대로  
					}
				} else if(d ==2) { // 하 
					if(n==1) {
						d = 3; //오른쪽으로 
					} else if(n == 2 || n == 3 || n== 5) {
						d = (d+2) % 4; //반대로 
					} else if( n == 4) {
						d = 1; //왼쪽으로 
					}
				} else if(d == 3) { // 우 
					if(n==1 || n==2 || n==5) {
						d = (d+2) % 4; //반대로 
					} else if(n == 3) {
						d = 2; //아래로 
					} else if( n == 4) {
						d = 0; //위로 
					}
				}
				continue;
			}
			
			//웜홀을 만났다면 (6~10)
			if(6 <= map[y][x] && map[y][x] <= 10) {
				//웜홀 찾으러 가기 
				int v[] = wormHole(y, x, map[y][x]);//현재 위치의 번호 
				y = v[0];
				x = v[1];
				continue;
			}
			
			
		}
		
	}

	private static int[] wormHole(int y, int x, int num) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!((y==i)&&(x==j)) && map[i][j] == num) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
	
	

}
