package baekjoon;

import java.util.*;
import java.io.*;

public class 강대은_BJ_2239_스도쿠 {

	static int[][] map;
	static ArrayList<int[]> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		map = new int[9][9];
		list = new ArrayList<int[]>();
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) list.add(new int[] {i, j});
			}
		}
		
		check(0);
	}
	
	private static void check(int cnt) throws IOException{
		if(list.size() == cnt) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					bw.write(map[i][j]+"");
				}
				bw.write("\n");
			}
			
			bw.flush();
			bw.close();
			br.close();
			
			System.exit(0);
		}
		
		int y = list.get(cnt)[0];
		int x = list.get(cnt)[1];
		
		boolean[] visit = new boolean[10];
		
		for(int i = 0; i < 9; i++) {
			if(map[y][i] != 0) visit[map[y][i]] = true;
		}
		
		for(int i = 0; i < 9; i++) {
			if(map[i][x] != 0) visit[map[i][x]] = true;
		}
		
		int startY = (y/3) * 3;
		int startX = (x/3) * 3;
		for(int i = startY; i < startY + 3; i++) {
			for(int j = startX; j < startX + 3; j++) {
				if(map[i][j] != 0) visit[map[i][j]] = true;
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			if(!visit[i]) {
				map[y][x] = i;
				check(cnt + 1);
				map[y][x] = 0;
			}
		}
		
	}

}
