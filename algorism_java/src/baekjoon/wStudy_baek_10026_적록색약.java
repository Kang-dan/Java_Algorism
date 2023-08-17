/*
 * 아이디어 
 * 배열 2개 (입력배열 map, BFS돌 때 확인용 배열 newMap)
 * BFS + 사방탐색 
 * BFS 호출 횟수 = 구역 개수 
 * 
 * 어려운점 : BFS와 사방탐색을 활용해야겠다는 생각은 했는데, 구체적인 처리과정이 어려웠음 (2차원배열 인덱스를 큐에 넣는 걸 자바로 구현하기 어려웠음)
 * 적록색약인 사람을 비효율적으로 코딩한 느낌. 
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class wStudy_baek_10026_적록색약 {
	
	static int mapSize;
	static char[][] map; //입력받을 배열 
	static int[][] newMap; //BFS에서 방문한 방 1로 체크할 배열 
	static int cntNoRGB = 0; //적록색약 아닌사람 구역 개수 (= BFS 호출 횟수)
	static int cntYesRGB = 0; //적록색약인 사람 구역 개수 (= BFS 호출 횟수)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		mapSize = Integer.parseInt(br.readLine());
		map = new char[mapSize][mapSize];
		newMap = new int[mapSize][mapSize];
		
		for(int i = 0; i < mapSize; i++) {
			String st = br.readLine();
			for(int j = 0; j < mapSize; j++) {
				map[i][j] = st.charAt(j);
			}
		}
				
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				if(newMap[i][j] != 1) bfs적록색약아닌사람(map[i][j], i, j);
			}
		}		
		bw.write(cntNoRGB+" "); //적록색약 아닌사람 구역개수 출력 
		
		newMap = new int[mapSize][mapSize]; //다시 초기화 
		
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				if(newMap[i][j] != 1) bfs적록색약사람(map[i][j], i, j);
			}
		}
		bw.write(cntYesRGB+"\n");
		
		bw.flush();
		bw.close();
		
	}


	private static void bfs적록색약사람(char RGB, int i, int j) { //R과 G는 같은구역 (B인 것과 B가 아닌 곳)
		cntYesRGB++;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j}); //첫 노드 삽입 
		
		newMap[i][j] = 1; //삽입할 때 1로 바꿔주기 
		
		int[] y = {0, 1, 0, -1}; //오 아 왼 위 
		int[] x = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] visit = q.poll(); //RGB 중 하나 
			int curY = visit[0];
			int curX = visit[1];
			//사방탐색 
			for(int d = 0; d < 4; d++) {
				int nextY = curY + y[d];
				int nextX = curX + x[d];
				
				if( 0 <= nextY && nextY < mapSize && 0 <= nextX && nextX < mapSize ) { //배열범위 조건 
					if(RGB == 'B') {  //B라면 
						if( map[nextY][nextX] == 'B' && newMap[nextY][nextX] != 1) { //같은 색이고, 방문하지 않았다면 
							q.offer(new int[]{nextY, nextX}); //큐에 삽입하고 
							newMap[nextY][nextX] = 1; // 방문확인배열에 1로 바꿔주기 
						}
					} else { //R이나 G라면 (B가 아니면 같은 색) 
						if( map[nextY][nextX] != 'B' && newMap[nextY][nextX] != 1) { //같은 색이고, 방문하지 않았다면 
							q.offer(new int[]{nextY, nextX}); //큐에 삽입하고 
							newMap[nextY][nextX] = 1; // 방문확인배열에 1로 바꿔주기 
						}
					}
				}
				
			}
		}
				
	}
	
	private static void bfs적록색약아닌사람(char RGB, int i, int j) {
		cntNoRGB++;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j}); //첫 노드 삽입 
		
		newMap[i][j] = 1; //삽입할 때 1로 바꿔주기 
		
		int[] y = {0, 1, 0, -1}; //오 아 왼 위 
		int[] x = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] visit = q.poll(); //RGB 중 하나 
			int curY = visit[0];
			int curX = visit[1];
			
			//사방탐색 
			for(int d = 0; d < 4; d++) {
	            int nextY = curY + y[d];
	            int nextX = curX + x[d];
	            
				if( 0 <= nextY && nextY < mapSize && 0 <= nextX && nextX < mapSize ) { //배열범위 조건 
					if( map[nextY][nextX] == RGB && newMap[nextY][nextX] != 1) { //같은 색이고, 방문하지 않았다면 
						q.offer(new int[]{nextY, nextX}); //큐에 삽입하고 
						newMap[nextY][nextX] = 1; // 방문확인배열에 1로 바꿔주기 
					}
				}
			}		
		}	
		
	}
		
}
