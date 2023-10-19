package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_1916_최소비용구하기 {

	static int N, M, S, E;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, w});
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		dij(S, 0); // 출발, 비용 
		
		bw.write(map[E]+"");
		bw.flush();
	}
	
	static int[] map;
	static boolean[] check;
	private static void dij(int s, int cost) {
		check = new boolean[N+1];
		map = new int[N+1];
		Arrays.fill(map, Integer.MAX_VALUE);//최댓값으로 채우기 
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		q.offer(new int[] {s, cost});
		map[s] = 0; //출발지점 
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int vertex = v[0];// 정점 
			int cos = v[1]; // 비용 
			if(check[vertex]) continue;
			check[vertex] = true;
			
			for(int i = 0; i < list[vertex].size(); i++) {
				int next = list[vertex].get(i)[0];
				int nextC = list[vertex].get(i)[1];
				if(map[next] > map[vertex] + nextC) {
					map[next] = map[vertex] + nextC;
					q.offer(new int[] {next, map[next]});
				}
				
			}
		}
		
	}

}
