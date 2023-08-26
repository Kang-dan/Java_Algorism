package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_모의SW역평_1953_탈주범검거 {

	static int N, M, R, C, L;
	static int resultCnt;
	static int[][] map;
	static boolean[][] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= tCnt; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //세로길이
			M = Integer.parseInt(st.nextToken()); //가로길이
			
			R = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 위치 
			C = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 위치 
			
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간 
			
			map = new int[N + 2][M + 2];
			isVisit = new boolean[N + 2][M + 2];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			resultCnt = 0; // 초기화 
			q.clear();
			bfs(R+1, C+1); //현재 맨홀 위치, 현재시간부터 증가 
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static Queue<int[]> q = new ArrayDeque<>();
	
	private static void bfs(int y, int x) {
		int time = 0;
		q.offer(new int[] {y, x});
		isVisit[y][x] = true; //방문체크 
		
		while(!q.isEmpty()) {
			if(time == L) return; //시간증가 (L일 떄까지)
			int size = q.size();
			
			for(int i = 0; i < size; i++) {	
				int[] v = q.poll();
				resultCnt++;
				int a = v[0];
				int b = v[1];
				
				if(map[a][b] == 1 || map[a][b] == 3 || map[a][b] == 4 || map[a][b] == 5) {
					오(a, b);
				}
				if(map[a][b] == 1 || map[a][b] == 2 || map[a][b] == 5 || map[a][b] == 6) {
					아(a, b);
				}
				if(map[a][b] == 1 || map[a][b] == 3 || map[a][b] == 6 || map[a][b] == 7 ) {
					왼(a, b);
				}
				if(map[a][b] == 1 || map[a][b] == 2 || map[a][b] == 4 || map[a][b] == 7) {
					위(a, b);
				}
				
			}
			
			time++;
		}
	}
	
	private static void 오(int a, int b) {  //왼쪽방향으로 갈 수 있는 터널이 있으면 큐에 추가 
		if(!isVisit[a][b + 1] &&  map[a][b + 1] != 0) {
			if(map[a][b + 1] == 1 || map[a][b + 1] == 3 || map[a][b + 1] == 6 || map[a][b + 1] == 7) {
				q.offer(new int[] {a, b + 1});
				isVisit[a][b + 1] = true;
			}
		}
	}
	
	private static void 아(int a, int b) { //위쪽방향으로 갈 수 있응 터널이 있으면 큐 추가 
		if(!isVisit[a + 1][b] && map[a + 1][b] != 0) {
			if(map[a + 1][b] == 1 || map[a + 1][b] == 2 || map[a + 1][b] == 4 || map[a + 1][b] == 7) {
				q.offer(new int[] {a + 1, b});
				isVisit[a + 1][b] = true;
			}
		}
	}
	
	private static void 왼(int a, int b) { //오른쪽방향으로 갈 수 있는 터널이 있으면 큐 추가 
		if(!isVisit[a][b - 1] && map[a][b - 1] != 0) {
			if(map[a][b - 1] == 1 || map[a][b - 1] == 3 || map[a][b - 1] == 4 || map[a][b - 1] == 5) {
				q.offer(new int[] {a, b - 1});
				isVisit[a][b - 1] = true;
			}
		}
	}
	
	private static void 위(int a, int b) { //아래쪽방향으로 갈 수 있는 터널이 있으면 큐 추가 
		if(!isVisit[a - 1][b] && map[a - 1][b] != 0) {
			if(map[a - 1][b] == 1 || map[a - 1][b] == 2 || map[a - 1][b] == 5 || map[a - 1][b] == 6) {
				q.offer(new int[] {a - 1, b});
				isVisit[a - 1][b] = true;
			}
		}
	}

}
