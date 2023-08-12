/*
 * 9명 중 7명 난쟁이, 7명의 숫자의 합이 100 (중복 안됨, 123 321 하나의 경우)
 * 7개의 수를 찾 (조합) 
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_3040_백설공주와일곱난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] nan; //9명 난쟁이
	static int[] select; //7명 난쟁이 
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		
		select = new int[7];
		isSelected = new boolean[9];
		nan = new int[9];
		for(int i = 0; i < 9; i++) {
			nan[i] = Integer.parseInt(br.readLine());
		}
		
		조합(0, 0);
	}
	
	private static void 조합(int cnt, int start) throws IOException {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) sum += select[i];
			if(sum == 100) {
				for(int i = 0; i < 7; i++) bw.write(select[i]+"\n");
				bw.flush();
				bw.close();
				br.close();
				System.exit(0);
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			if(isSelected[i]) continue;
			select[cnt] = nan[i];
			isSelected[i] = true;
			조합(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}
}
