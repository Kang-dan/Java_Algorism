package algorism_java;

import java.util.*;
import java.io.*;

public class BJ_2239_스도쿠_순열로풀어보자 {

	static int[][] map = new int[9][9];
	static boolean[] nonNum;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		//가로줄 없는 숫자 배열
		int numCnt;
		for(int i = 0; i < 9; i++) {
			nonNum = new boolean[9];
			numCnt = 0;
			for(int j = 0; j < 9; j++) {
				if(map[i][j] != 0) {
					numCnt++;
					nonNum[map[i][j]-1] = true; //번호가 있는 곳  
				}
			}
			int c = 0;
			input = new int[9-numCnt]; //없는 숫자 담을 배열 
			for(int j = 0; j < 9; j++) {
				if(!nonNum[j]) input[c++] = j+1;
			}
			Arrays.sort(input);
			select = new boolean[10];
			newInput = new int[input.length];
			순열(input, 0, i);
		}
		
		//출력
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				bw.write(map[i][j] + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		

	}
	
	static boolean[] select;
	static int[] newInput;
	
	private static void 순열(int[] input, int cnt, int r) {
		//가로줄 완성될 때마다 -> 세로줄, 3x3확인하기 
		if(cnt == input.length) {
			//세로줄 확인하러가기 
			//3X3확인하러가기 
			if(sero(newInput, r) && check3(map, newInput, r)) {
				int idx = 0;
				for(int j = 0; j < 9; j++) {
					if(map[r][j] == 0) map[r][j] = newInput[idx++];
				}
				newInput = new int[input.length];
				return;
			}
			return;
		}
		
		for(int i = 0; i < input.length; i++) {
			if(select[i]) continue;
			select[i] = true;
			newInput[cnt] = input[i];
			순열(input, cnt+1, r);
			select[i] = false;
		}
	}
	
	// 현재 + 
	private static boolean check3(int[][] map2, int[] newInput2, int r) {
		boolean[] check;
		int cnt = 0;
		int y = r - r%3;
		for(int i = 0; i < 9; i++) {
			if(map2[r][i] == 0) {
				map2[r][i] = newInput2[cnt++];
			}
		}
		check = new boolean[10];
		for(int i = y; i < y+3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map2[i][j]!=0 && check[map2[i][j]]) return false;
				if(map2[i][j] != 0) check[map2[i][j]] = true;
			}
		}
		check = new boolean[10];
		for(int i = y; i < y+3; i++) {
			for(int j = 3; j < 6; j++) {
				if(map2[i][j]!=0 && check[map2[i][j]]) return false;
				check[map2[i][j]] = true;
			}
		}
		check = new boolean[10];
		for(int i = y; i < y+3; i++) {
			for(int j = 6; j < 9; j++) {
				if(map2[i][j]!=0 && check[map2[i][j]]) return false;
				check[map[i][j]] = true;
			}
		}
		return true;
	}
	
	private static boolean sero(int[] newInput2, int r) {
		int cnt = 0;
		for(int i = 0; i < 9; i++) {
			if(map[r][i]==0) {
				int v = newInput2[cnt++];
				for(int j = 0; j < 9; j++) {
					if(map[j][i] == v) {
						return false;
					}
				}
			}
		}
		return true;
	}

}