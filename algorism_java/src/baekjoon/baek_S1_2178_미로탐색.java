/*
 * BFS + 사방탐색 + 레벨별 탐색 
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_S1_2178_미로탐색 {

	static int[][] map;
	static boolean[][] visit; // 도착지점 인덱스에 있는 값이 최소 이동횟수
	static int a, b;
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    //입력 
    st = new StringTokenizer(br.readLine()); //배열 크기 입력 
    a = Integer.parseInt(st.nextToken()); //세로길이 
    b = Integer.parseInt(st.nextToken()); //가로길이
    
    map = new int[a+2][b+2];
    visit = new boolean[a+2][b+2];
    
    for(int i = 1; i <= a; i++) {
        String num = br.readLine();
        for(int j = 1; j <= b; j++) {
            map[i][j] = num.charAt(j-1) - '0';
        }
    }

    // 과정 : (0,0)출발 -> (y-1,x-1)도착 
    // bfs이용 , 방문했으면 visit맵에 1로 표시, 사방탐색하다가 1이 두개 이상 나오면, 재귀 사용(여기서 발견하면 그대로 
    /*
     * bfs + 사방탐색 + (방법 3가지 1. 레벨별 탐색(size) 2.방문배열에 레벨을 넣어주기 3.큐에 배열을 넣어줘서 인덱스랑 레벨을 넣어주기)
     * -> 위 3가지 방법 중 하나 사용하면 됨! 
     */
    
    int move = bfs();
    bw.write(move + "\n");
    
    bw.close();
    br.close();
    
	}
	
	public static int bfs() {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{1, 1}); //인덱스 삽입  (인덱스i, 인덱스j, 이동수)
		
		int[] dy = {0, 1, 0, -1}; //오 아 왼 위 
		int[] dx = {1, 0, -1, 0};
		int[] v = new int[2];
		
		int move = 1;
		while(!q.isEmpty()) {
			int length = q.size();
			
			for(int i = 0; i < length; i++) {
				v = q.poll();
				
				int y = v[0];
				int x = v[1];
				
//				visit[y][x] = true; //방문표시를 여기에 두면 메모리초과남 왜??
				
				if(y == a && x == b) return move;
				
				for(int d = 0; d < 4; d++) {
					if(map[y + dy[d]][x + dx[d]] == 1 && visit[y + dy[d]][x + dx[d]] == false) {
						q.offer(new int[] {y + dy[d], x + dx[d]});
						visit[y + dy[d]][x + dx[d]] = true;  //여기서 방문표시해야 메모리초과 안남 !!
					}
				}
			}
			move++;
		}
		return 0;
		
	}
}
