package algorism_java;

import java.util.*;
import java.io.*;

public class SWEA_6808_규영이와인영이의카드게임 {

	static int[] numbers;
	static int[] inyong;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <=T; test++) {
			st = new StringTokenizer(br.readLine());
			
			//규영이 
			int[] guyong = new int[19];
			for(int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				guyong[num] = 1;
			}
			
			//인영이
			inyong = new int[8];
			int count = 0;
			for(int i = 1; i <= 18; i++) {
				if(guyong[i] == 0) inyong[count++] = i;
			}
			
			순열(0);
			
		}
		
	}
	
	private static void 순열(int cnt) {
		if(cnt == 9) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 0; i < 9; i++) {
			numbers[cnt] = inyong[i];
			순열(cnt+1);
		}
	}

}
