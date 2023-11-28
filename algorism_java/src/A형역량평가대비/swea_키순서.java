package A형역량평가대비;

import java.io.*;
import java.util.*;

public class swea_키순서 {

	static int tCnt, N, M;
	static ArrayList<Integer>[] list1;
	static ArrayList<Integer>[] list2;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			list1 = new ArrayList[N+1];
			list2 = new ArrayList[N+1];
			
			
			for(int i = 1; i <= N; i++) {
				list1[i] = new ArrayList<>();
				list2[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list1[a].add(b);
				list2[b].add(a);
			}
			
			int sum1 = 0, sum2 = 0;
			int result = 0;
			for(int i = 1; i <= N; i++) {
				visit = new boolean[N+1];
				n1= 0; n2 = 0;
				
				sum1 = up(i, list1);
				
				visit = new boolean[N+1];
				sum2 = down(i, list2);
				
				if(sum1 + sum2 == N-1) result++;
			}
			
			bw.write(String.format("#%d %d\n", test, result));
		}
		bw.flush();
	}
	
	static int n1, n2;
	private static int down(int a, ArrayList<Integer>[] list2) {
		for(int i = 0; i < list2[a].size(); i++) {
			int n = list2[a].get(i);
			if( !visit[n] ) {
				visit[n] = true;
				n1++;
				down(n, list2);
			}
		}
		
		return n1;
	}
	private static int up(int a, ArrayList<Integer>[] list1) {
		for(int i = 0; i < list1[a].size(); i++) {
			int n = list1[a].get(i);
			if( !visit[n] ) {
				visit[n] = true;
				n2++;
				up(n, list1);
			}
		}
		
		return n2;
	}

}
