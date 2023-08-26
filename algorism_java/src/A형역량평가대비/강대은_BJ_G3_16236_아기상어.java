package A형역량평가대비;

import java.util.*;
import java.io.*;

public class 강대은_BJ_G3_16236_아기상어 {
	
	static int[][] map;
	static int babySize, mapSize;
	static boolean[][] isVisit;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    mapSize = Integer.parseInt(br.readLine());
	    map = new int[mapSize][mapSize];
	    
	    //아기상어 위치 저장하기 
	    int babyY = 0, babyX = 0;
	    for(int i = 0; i < mapSize; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j = 0; j < mapSize; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            if(map[i][j] == 9) {
	                babyY = i;
	                babyX = j;
	            }
	        }
	    }
	    
	    isVisit = new boolean[mapSize][mapSize];
	    
	    //다 돌았거나 더이상 갈 수 없는데 먹은 개수가 < 내 크기 값 이면 끝 
	    bfs(babyY, babyX, 2, 0); //아기상어 위치, 현재 크기, 움직인 누적칸 (=시간)
	
	}
	
	//순서 중요! (위, 왼, 아, 오)
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	//아기상어가 이동한 1칸 = 1초 
	// 0 빈칸, 1~6 물고기 크기, 9 아기상어 위치 
	// 크기가 커질 때마다 방문표시 초기화해주기
	static int eatCnt;
	private static void bfs(int y, int x, int size, int move) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.offer(new int[] {y, x, size, move});
	    isVisit[y][x] = true;
	    
	    while(!q.isEmpty()) {
	        int[] v = q.poll();
	        int a = v[0];
	        int b = v[1];
	        int curSize = v[2];
	        int time = v[3];
	        
	        if(curSize < size) {
	        	eatCnt++;
	        	
	        }
	        
	        //사방탐색하면서 자신보다 더 작은 물고기 발견하면 0으로 바꿔주고, 먹은 카운트 증가 
	        for(int d = 0; d < 4; d++) {
	            if(a + dy[d] < 0 || a + dy[d] >= mapSize || b + dx[d] < 0 || b + dx[d] >= mapSize) continue;
	            if(map[a + dy[d]][b + dx[d]] <= size && !isVisit[a + dy[d]][b + dx[d]]) {
	            	q.offer(new int[] {a + dy[d], b + dx[d], map[a + dy[d]][b + dx[d]], time+1} );
	            	isVisit[a + dy[d]][b + dx[d]] = true;
	            }
	        }
	    }
	    
	}
}