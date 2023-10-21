// bfs + 스택 
package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_13913_숨바꼭질4 {

	static int N, K;
	static boolean[] visit;
	static int[] parent;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int M = Math.max(N, K);
		visit = new boolean[200001];
		parent = new int[200001];
		
		visit[N] = true;
		bfs(N);

	}
	
	private static void bfs(int s) throws IOException {
		Queue<int[]> q = new ArrayDeque<>();
		Stack<Integer> stack = new Stack<>();
		
		q.offer(new int[] {s, 0});
		visit[s] = true;
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int a = v[0];
			int t = v[1];
			
			if(a == K) {
				Arrays.fill(visit, false);
				int[] arr = new int[t+1];
				visit[N] = true;
				arr[0] = N;
				bw.write(t + "\n");
				
				//스택 넣기
				int cur = K;
				while(cur != N) {
					stack.push(cur);
					cur = parent[cur];
				}
				stack.push(N);
				//출력 
				while(!stack.isEmpty()) {
					bw.write(stack.pop()+" ");
				}
				bw.flush();
				
				bw.close();
				br.close();
//				dfs(t, 0, N, arr);
				return;
			}
			
			if(a-1 >= 0 && !visit[a-1]) {
				q.offer(new int[] {a-1, t+1});
				visit[a-1] = true;
				parent[a-1] = a;
			}
			if(a+1 <= 2*K && !visit[a+1]) {
				q.offer(new int[] {a+1, t+1});
				visit[a+1] = true;
				parent[a+1] = a;
			}
			if(a * 2 <= 2*K && !visit[a*2]) {
				q.offer(new int[] {2*a, t+1});
				visit[a*2] = true;
				parent[a*2] = a;
			}
			
		}
	}
	
//	private static void dfs(int cnt, int go, int s, int[] arr) throws IOException {
//		if(cnt == go) {
//			if(s != K) return;
//			if(s == K) {
//				//출력
//				for(int i = 0; i <= cnt; i++) {
//					bw.write(arr[i] + " ");
//				}
//				bw.flush();
//				System.exit(0);
//			}
//		}
//	
//		if(s-1 >= 0 && !visit[s-1]) {
//			visit[s-1] = true;
//			arr[go+1] = s-1;
//			dfs(cnt, go+1, s-1, arr);
//			visit[s-1] = false;
//		}
//		if(s+1 <= 2*K && !visit[s+1]) {
//			visit[s+1] = true;
//			arr[go+1] = s+1;
//			dfs(cnt, go+1, s+1, arr);
//			visit[s+1] = false;
//		}
//		if(s*2 <= 2*K && !visit[s*2]) {
//			visit[s*2] = true;
//			arr[go+1] = s*2;
//			dfs(cnt, go+1, s*2, arr);
//			visit[2*s] = false;
//		}
//		
//		
//	}

}
