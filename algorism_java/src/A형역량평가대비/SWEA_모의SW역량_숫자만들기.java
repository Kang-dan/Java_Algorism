// 중복순열은 통과. 일반순열은 시간초과

package A형역량평가대비;

import java.util.*;
import java.io.*;

public class SWEA_모의SW역량_숫자만들기 {

	static int N, max, min;
	static int[] num;
	static int[] count;
	static char[] result; // 순열결과 배열 
	static char[] notNum = {'+', '-', '*', '/'}; //연산자 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			count = new int[4];
			num = new int[N];
			result = new char[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}
            
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0);
			
			bw.write(String.format("#%d %d\n", test, max-min));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			//계산 후 최대, 최소 확인 
			int r = num[0];
			int a=0, b=0, c=0, d=0;
			for(int i = 0; i < N-1; i++) {
				if(result[i] == '+') {
					a++;
					if(count[0] < a) return;
					r += num[i+1];
				}
				else if(result[i] == '-') {
					b++;
					if(count[1] < b) return;
					r -= num[i+1];
				}
				else if(result[i] == '*') {
					c++;
					if(count[2] < c) return;
					r *= num[i+1];
				}
				else if(result[i] == '/') {
					d++;
					if(count[3] < d) return;
					r /= num[i+1];
				}
			}
            
			if(r < min) min = r;
			if(r > max) max = r;
			return;
		}
		for(int i = 0; i < 4; i++) {
			result[cnt] = notNum[i];
			perm(cnt + 1);
		}
		
	}
	
}

/* 일반순열 (시간초과남)
public class SWEA_모의SW역량_숫자만들기 {

	static int N, max, min;
	static boolean[] visit;
	static int[] num;
	static int[] count;
	static char[] input; //연산자 배열 
	static char[] result; // 순열결과 배열 
	static char[] notNum = {'+', '-', '*', '/'}; //연산자 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N-1];
			count = new int[4];
			num = new int[N];
			input = new char[N-1];
			result = new char[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}
			int plus = 0;
			for(int i = 0; i < 4; i++) {
				int a = Integer.parseInt(st.nextToken());
				for(int j = 0; j < a; j++) {
					input[plus++] = notNum[i]; // 연산자 배열 
				}
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0);
			
			bw.write(String.format("#%d %d\n", test, max-min));
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			//계산 후 최대, 최소 확인 
			int r = num[0];
			for(int i = 1; i < N; i++) {
				switch(result[i-1]) {
				case '+' : r += num[i];
				break;
				case '-' : r -= num[i];
				break;
				case '*' : r *= num[i];
				break;
				case '/' : r /= num[i];
				}
			}
			
			if(r < min) min = r;
			if(r > max) max = r;
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[cnt] = notNum[i];
			perm(cnt + 1);
			visit[i] = false;
		}
		
	}
}
*/