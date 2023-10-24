package baekjoon;

import java.util.*;
import java.io.*;

public class BJ_11779_최소비용구하기2 {

	static int N, M, S, E;
	static ArrayList<int[]>[] list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
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
		
		
		bw.flush();
	}
	
	static int[] map;
	static boolean[] check;
	static int[] parents; // 경로찾기 
	private static void dij(int s, int cost) throws IOException {
		check = new boolean[N+1];
		map = new int[N+1];
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		Arrays.fill(map, Integer.MAX_VALUE);//최댓값으로 채우기 
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //2차원 정렬
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
					parents[next] = vertex;
					q.offer(new int[] {next, map[next]});
				}
				
			}
		}
		
		bw.write(map[E]+"\n");
		
//		Arrays.sort(parents);
//		System.out.println(Arrays.toString(parents));
		int[] path = new int[N+1];
		path[0] = E;
		int i = 0, child = parents[E], parent = E;
		while(true) {
			if(child == S) break;
			child = parents[parent]; //거꾸로 
			path[++i] = child;
			parent = child;
		}
//		System.out.println(Arrays.toString(path));
		path[i] = S;
		
		bw.write(i+1+"\n");
		
		for(int j = i; j >= 0; j--) {
			bw.write(path[j]+" ");
		}
		
	}

}
