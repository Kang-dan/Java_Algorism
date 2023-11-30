package baekjoon;

import java.util.*;
import java.io.*;

public class baek_13549_숨바꼭질3 {

	static int N, K;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int l = Math.max(N, K);
		visit = new boolean[2*l+1];
		
		int time = bfs(N, 0); //수빈 위치, 시간 

		bw.write(time+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int bfs(int n, int t) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {n, 0});
		visit[n] = true;
		
		while(!q.isEmpty()) {

			int[] v = q.poll();
			int a = v[0];
			int b = v[1];
			if(a == K) return b;
			
			//순서 중요! 
			if(a*2 <= 2*K && !visit[a*2]) {
				q.offer(new int[] {a*2, b});
				visit[a*2] = true;
			}
			
			if(a-1 >= 0 && !visit[a-1]) {
				q.offer(new int[] {a-1, b+1});
				visit[a-1] = true;
			}
			
			if(a+1 <= 2*K && !visit[a+1]) {
				q.offer(new int[] {a+1, b+1});
				visit[a+1] = true;
	    	}
				
		}

		return 0;
	}

}
