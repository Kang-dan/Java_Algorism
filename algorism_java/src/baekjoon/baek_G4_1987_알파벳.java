package baekjoon;

import java.util.*;
import java.io.*;

public class baek_G4_1987_알파벳 {

	static int r, c;
	static char[][] map;
	static boolean[] alpaVisit;
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		alpaVisit = new boolean[26];
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		alpaVisit[map[0][0] - 'A'] = true;
		
		bw.write(dfs(0,0) + "");		
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static int dfs(int y, int x) {
		int cnt = 1;
		
		for(int d = 0; d < 4; d++) {
			if(y + dy[d] < 0 || y + dy[d] >= r || x + dx[d] < 0 || x + dx[d] >= c || alpaVisit[map[y + dy[d]][x + dx[d]] - 'A']) continue;
			
			alpaVisit[map[y + dy[d]][x + dx[d]] - 'A'] = true;				
			cnt = Math.max(cnt, 1 + dfs(y+dy[d], x+dx[d]));
			alpaVisit[map[y + dy[d]][x + dx[d]] - 'A'] = false;	
		}
		
		return cnt;
	}

}
