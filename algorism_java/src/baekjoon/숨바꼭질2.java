package baekjoon;

import java.util.*;
import java.io.*;

public class 숨바꼭질2 {

	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[200001];
		bfs(N, K, 0);
		
		bw.write(time + "\n" + cnt);
		
		bw.flush();

	}
	
	static int time, cnt;
	static boolean[] visit;
	private static void bfs(int s, int e, int t) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {s, t}); //출발, 시간 
		visit[s] = true;
		
		time= 0; cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] v = q.poll();
				int a = v[0];
				int b = v[1];
				visit[a] = true;
				
				if(a == e) {
					cnt++;
					time = b;
				}
				
				if(a+1 <= 200000 && !visit[a+1]) q.offer(new int[] {a + 1, b + 1});
				if(a-1 >=0 && !visit[a-1]) q.offer(new int[] {a - 1, b + 1});
				if(a*2 <= 200000 && !visit[a*2]) q.offer(new int[] {a * 2, b + 1});
			}
			
			if(cnt > 0) return;
		}
	}

}
