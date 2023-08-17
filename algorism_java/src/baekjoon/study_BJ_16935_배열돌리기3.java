package baekjoon;

import java.util.*;
import java.io.*;

public class study_BJ_16935_배열돌리기3 {
	
	static int[][] map;
	static int sizeY, sizeX, rotate;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		sizeY = Integer.parseInt(st.nextToken());
		sizeX = Integer.parseInt(st.nextToken());
		rotate =  Integer.parseInt(st.nextToken());
		
		map =  new int[sizeY][sizeX];
		
		for(int i = 0; i < sizeY; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < sizeX; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		int num = Integer.parseInt(br.readLine());

//		가로줄바꾸기();
//		세로줄바꾸기();
//		오른쪽구십도회전();
//		왼쪽구십도회전(); //오른쪽구십도회전을 3번 반복 
//		
//		
	
		int[][] newMap = new int[sizeY][sizeX];
		작은배열회전(0, 0, sizeY/2, 0, newMap); //오번 
		작은배열회전(0, sizeX/2, 0, 0, newMap);
		작은배열회전(sizeY/2, sizeX/2 , 0, sizeY/2, newMap);
		작은배열회전(sizeY/2, 0, sizeY/2, sizeX/2, newMap);
		map = newMap;
		
		
		육번(); //5번을 3번 쓰면됨.
		
		이번(); //3,1,4번꺼를 쓰면됨.
		
		
		//출력 
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) bw.write(map[i][j]+" ");
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	

	
	private static void 작은배열회전(int x1, int y1, int x2, int y2, int[][] newMap) {
		for(int i = 0; i < sizeY/2; i++) {
			for(int j = 0; j < sizeX/2; j++) {
				newMap[x1 + i][y1 + j] = map[x2 + i][y2 + j];
			}
		}
		
	}



	private static void 왼쪽구십도회전() {
		오른쪽구십도회전();
		오른쪽구십도회전();
		오른쪽구십도회전();		
	}


	private static void 오른쪽구십도회전() {
		int[][] newMap = new int[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				newMap[i][j] = map[sizeY-j-1][i];
			}
		}
		int temp = sizeY;
		sizeY=sizeX;
		sizeX = temp;
		
		map = newMap;
	}



	private static void 가로줄바꾸기() {
		int[][] newMap = new int[sizeY][sizeX]; //새로운 맵
		for(int i = 0; i < sizeY; i++) newMap[i] = map[sizeY - i - 1];
		map = newMap; 
	}


	private static void 세로줄바꾸기() {
		int[][] newMap = new int[sizeY][sizeX]; //새로운 맵
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				newMap[i][j] = map[i][sizeX - j - 1];
			}
		}
		map = newMap;
	}
	
}
