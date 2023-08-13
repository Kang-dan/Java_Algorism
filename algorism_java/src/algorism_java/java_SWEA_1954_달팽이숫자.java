package algorism_java;

import java.util.*;
import java.io.*;

public class java_SWEA_1954_달팽이숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			int mapSize = Integer.parseInt(br.readLine());
			int[][] map = new int[mapSize][mapSize];
			
			int i = 0, j = 0, cnt = 1;
			while(cnt <= mapSize * mapSize) {
				//오 
				while(cnt <= mapSize * mapSize && j < mapSize && map[i][j] == 0) {
					map[i][j] = cnt++;
					j++;
				} j--; i++;
				
				//아 
				while(cnt <= mapSize * mapSize && i < mapSize && map[i][j] == 0) {
					map[i][j] = cnt++;
					i++;
				} i--; j--;
				
				//왼 
				while(cnt <= mapSize * mapSize && j >= 0 && map[i][j] == 0) {
					map[i][j] = cnt++;
					j--;
				} j++; i--;
				
				//위 
				while(cnt <= mapSize * mapSize && i >= 0 && map[i][j] == 0) {
					map[i][j] = cnt++;
					i--;
				} i++; j++;
			}
			
			bw.write(String.format("#%d\n", test));
			for(int a = 0; a < mapSize; a++) {
				for(int b = 0; b < mapSize; b++) bw.write(map[a][b]+" ");
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
