package baekjoon;
/*
6
10 20 10 30 20 50
 */
import java.util.*;
import java.io.*;

public class baek_11053_가장긴증가하는부분수열 {

	static int N, MaxLength;
	static int[] input;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		increment();
		
		bw.write(MaxLength+"");
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static void increment() {
		for(int i = 1; i < Math.pow(2, N); i++) {
			result = new int[N];
			int tmp = 0;
			int length = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					if(input[j] <= tmp) {
						continue;
					}
					tmp = input[j];
					result[j] = input[j];
					length++;
				}
			}
			//확인하기 
//			int length = 0;
//			int tmp = 0;
//			for(int j = 0; j < N; j++) {
//				if(result[j] == 0) continue;
//				if(result[j] <= tmp) {
//					length = 0;
//					break;
//				}
//				tmp = result[j];
//				length++;
//			}
			MaxLength = Math.max(MaxLength, length);
		}
	}
}
