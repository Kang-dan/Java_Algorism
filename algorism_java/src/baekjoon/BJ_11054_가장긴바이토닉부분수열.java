//시간초과 
package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_11054_가장긴바이토닉부분수열 {

	static int A;
	static int[] arr;
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		A = Integer.parseInt(br.readLine());
		arr = new int[A];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//부분집합 바이너리 
		부분집합바이너리();
		
		bw.write(result+"");
		bw.flush();

	}
	
	private static void 부분집합바이너리() {
		for(int i = 1; i < Math.pow(2, A); i++) {
			input = new int[A];
			for(int j = 0; j < A; j++) {
				if((i & (1 << j)) != 0) input[j] = arr[j];
			}
			// 바이토닉 수열인지 확인
			바이토닉수열(input);
		}
	}

	static boolean flag;
	static int result;
	private static void 바이토닉수열(int[] input) {
		flag = false;
		int tmp = 0;
		int tmp2 = 0;
		int length = 0;
		for(int i = 0; i < A; i++) {
			if(input[i] == 0) continue;
			tmp = input[i];
			length++; //길이 
			
			for(int j = i+1; j < A; j++) {
				if(input[j] == 0) continue;
				tmp2 = input[j];
				if(tmp == tmp2) return; //숫자 크기 같으면 실패 
				if(tmp > tmp2) flag = true; // 내려가는 모양 
				if(tmp < tmp2 && flag) return; // 내려가고 올라간다면 실패
				break;
			}
		}
		
		result = Math.max(result, length);
	}
}
