package baekjoon;

/*
7
1 6
6 3
3 5
4 1
2 4
4 7
*/
import java.util.*;
import java.io.*;

public class baek_11725_트리의부모찾기 {

	static int N;
	static int[] parent;
	static boolean[] visit;
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		//부모배열 채우기 
		whoIsMyParent();
		
		for(int i = 2; i <= N; i++) {
			bw.write(parent[i]+"\n");
		}
		
		bw.flush();
//		bw.close();
//		br.close();
	}
	
	private static void whoIsMyParent() {
		Queue<Integer> q = new ArrayDeque<>();
		visit[1] = true;
		for(int i = 0; i < list[1].size(); i++) {
			int get = list[1].get(i);
			q.offer(get);
			visit[get] = true;
			parent[get] = 1; //부모가 1 
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i = 0; i < list[v].size(); i++) {
				if(visit[list[v].get(i)]) continue;
				q.offer(list[v].get(i));
				visit[list[v].get(i)] = true;
				parent[list[v].get(i)] = v;
			}
		}
	}

}
