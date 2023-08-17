package baekjoon;

import java.util.*;
import java.io.*;

public class baek_S1_1992_쿼드트리 {

	static int N;
	static int[][] map;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String st = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		
		querdTree(0, 0, N); //시작 인덱스, 크기 
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	
	private static void querdTree(int y, int x, int size) throws IOException {		
		int flag = map[y][x];
	    boolean isSame = true;
	    
	    for(int i = y; i < y + size; i++) {
	       for(int j = x; j < x + size; j++) {    
	    	   if(flag != map[i][j]) {
	    		   isSame = false;
		           break;
		       }
	       }
	       if (!isSame) break;
		}
		    
	    if (isSame) {
	    	bw.write(flag + "");
	        return;
		}
	    
	    int newSize = size / 2;
	    bw.write("(");
	    querdTree(y, x, newSize);
	    querdTree(y, x + newSize, newSize);
	    querdTree(y + newSize, x, newSize);
	    querdTree(y + newSize, x + newSize, newSize);
	    bw.write(")");
	
	}
}
