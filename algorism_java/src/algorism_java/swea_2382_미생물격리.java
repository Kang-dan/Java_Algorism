package algorism_java;

import java.util.*;
import java.io.*;

public class swea_2382_미생물격리 {

	static int mapSize, time, misanCnt;
	static int[][] misan;
	static int[][] misan2;
	static int[][] point;
	static int[][] point2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			mapSize = Integer.parseInt(st.nextToken()); //크기 
			time = Integer.parseInt(st.nextToken()); //시간 
			misanCnt = Integer.parseInt(st.nextToken()); //미생물 군집개수 
			
			misan = new int[mapSize][mapSize];
			point = new int[mapSize][mapSize];
			
			for(int i = 0; i < misanCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()); //세로
				int c = Integer.parseInt(st.nextToken()); //가로 
				int cnt = Integer.parseInt(st.nextToken()); //미생물 
				int p = Integer.parseInt(st.nextToken()); //방향 
				
				misan[r][c] = cnt;
				point[r][c] = p;
			}
			
			for(int t = 0; t < time; t++) {
				boolean[][] visit = new boolean[mapSize][mapSize];
				misan2 = new int[mapSize][mapSize];
				point2 = new int[mapSize][mapSize];
				go(visit);
				
				for(int i = 0; i < mapSize; i++) {
					for(int j = 0; j < mapSize; j++) {
						misan[i][j] = misan2[i][j];
						point[i][j] = point2[i][j];
					}
				}
				
//				System.out.println(t+" : ");
//				for(int i = 0; i < mapSize; i++) {
//					for(int j = 0; j < mapSize; j++) {
//						System.out.print(misan[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
			int result = 0;
			for(int i = 0; i < mapSize; i++) {
				for(int j = 0; j < mapSize; j++) {
					result += misan2[i][j];
				}
			}
//			System.out.println();
			
			bw.write(String.format("#%d %d\n", test, result));
		}
		
		bw.flush();
	}
	
	static int[] dr = {0, -1, 1, 0, 0}; // 상 하 좌 우 (1, 2, 3, 4)
	static int[] dc = {0, 0, 0, -1, 1};
	
	private static void go(boolean[][] visit) {
		
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				//약품 위치면
				if(i == 0 && point[i+1][j]==1) {
					misan2[i][j] = misan[i+1][j]/2;
					point2[i][j] = 2; // 방향 반대로
					point[i+1][j] = 0;
					misan[i+1][j] = 0;
					visit[i][j] = true;
					continue;
				} else if(i==mapSize-1 && point[i-1][j]==2) {
					misan2[i][j] = misan[i-1][j]/2;
					point2[i][j] = 1; // 방향 반대로 
					point[i-1][j] = 0;
					misan[i-1][j] = 0;
					visit[i][j] = true;
					continue;
				} else if(j==0 && point[i][j+1]==3) {
					misan2[i][j] = misan[i][j+1]/2;
					point2[i][j] = 4; // 방향 반대로 
					point[i][j+1] = 0;
					misan[i][j+1] = 0;
					visit[i][j] = true;
					continue;
				} else if(j==mapSize-1 && point[i][j-1]==4) {
					misan2[i][j] = misan[i][j-1]/2;
					point2[i][j] = 3; // 방향 반대로 
					point[i][j-1] = 0;
					misan[i][j-1] = 0;
					visit[i][j] = true;
					continue;
				}
				
				//약품 위치가 아니면 
				int[] max = new int[4];
				if(0<i && i<mapSize-1 && 0<j && j<mapSize-1) {
					Arrays.fill(max, 0);//세로,가로,미생물수,방향
					int sum = 0;
					for(int d=1; d <=4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						int v = point[r][c];
						int cnt = misan[r][c];
						if(visit[r][c] && misan[r][c]==0) continue;
						if((d==1 && v==2) || (d==2 && v==1) || (d==3 && v==4) || (d==4 && v==3)) {
							sum += cnt;
							if(cnt > max[2]) {
								max[0] = r;
								max[1] = c;
								max[2] = cnt;
								max[3] = v;
							}
							misan[r][c] = 0;
							point[r][c] = 0;
							visit[i][j] = true;
						}
						
					}
					if(visit[i][j] == true) {
						misan2[i][j] = sum;
						point2[i][j] = max[3];
					}
				}
			}
		}
	}

}
