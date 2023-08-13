/*
 * BFS이용 
 */
package algorism_java;

import java.util.*;
import java.io.*;

public class java_SWEA_1861_정사각형방 {	
	static int size;
	static int[][] map;
	static int startRoomNum; //처음 출발해야하는 방 번호
	static int maxRoomCnt; //최대 이동 수 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int testCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= testCnt; test++) {
			startRoomNum = 1;
			maxRoomCnt = 0;
			
			size = Integer.parseInt(br.readLine());
			map = new int[size+2][size+2];
			
			for(int i = 1; i <= size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= size; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= size; i++) {
				for(int j = 1; j <= size; j++) bfsSearch(i,j);
			}
			
			bw.write(String.format("#%d %d %d\n", test, startRoomNum, maxRoomCnt));
		}
		
		bw.close();
		br.close();
	}
	
	private static void bfsSearch(int y, int x) {
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		int startRoom = map[y][x];
		q.offer(map[y][x]);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			cnt++;
			
			//오
			if(v+1 == map[y][x+1]) q.offer(map[y][++x]);
			//아
			if(v+1 == map[y+1][x]) q.offer(map[++y][x]);
			//왼
			if(v+1 == map[y][x-1]) q.offer(map[y][--x]);
			//위 
			if(v+1 == map[y-1][x]) q.offer(map[--y][x]);
		}
		
		if(maxRoomCnt < cnt) {
			maxRoomCnt = cnt;
			startRoomNum = startRoom;
		} else if(maxRoomCnt == cnt && startRoomNum > startRoom) { //참고) 비교할때 Math.min() 사용하는 방법 있음.
			maxRoomCnt = cnt;
			startRoomNum = startRoom;
		}
	}

}
