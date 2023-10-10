package algorism_java;

import java.util.*;
import java.io.*;

public class swea_2239_스도쿠 {

	static int[][] map = new int[9][9];
	static boolean[] sudo = new boolean[9];
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) q.offer(new int[]{i, j});
			}
		}
		
		go();

	}
	
	private static void go() {
		
		for(int i = 0; i < 9; i++) {
			Arrays.fill(sudo, false);
			for(int j = 0; j < 9; j++) {
				sudo[map[i][j]] = true;
			}
			
			input(i, sudo);
			
		}
	}

	private static void input(int i, boolean[] sudo2) {
		for(int j = 0; j < 9; j++) {
			if(!sudo2[j]) {
				int[] v = q.poll();
				int r = v[0];
				int c = v[1];
				
				Check3x3(r,c, sudo2);
			}
		}
	}

	private static void Check3x3(int r, int c, boolean[] sudo2) {
		
	}

}
