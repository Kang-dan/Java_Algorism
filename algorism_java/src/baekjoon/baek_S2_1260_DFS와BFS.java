package baekjoon;

import java.util.*;
import java.io.*;

public class baek_S2_1260_DFS와BFS { //간선 양방향 , 방문표시하기 
	
	static int N, M, V;
	static int cnt; // 카운트 
	static ArrayList<Integer>[] list;
	static boolean[] isVisit;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
//		ArrayList<Node> list = new ArrayList<>(); //N개의 배열리스트 만들기 
		list = new ArrayList[N+1]; //N개의 배열리스트 만들기 
		isVisit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
		    list[i] = new ArrayList<>(); // 각 인덱스에 배열리스트를 초기화해줘야 함
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int node = Integer.parseInt(st.nextToken());
			list[start].add(node);
		}
		
		dfs(V);
		
		cnt = 0;
		
		bw.flush();
		
		
	}
	
	private static void dfs(int start) throws IOException {
		bw.write(start + " ");
		isVisit[start] = true;
//		cnt++;
//		if(cnt == N) return;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < list[start].size(); i++) {
			if(isVisit[list[start].get(i)]) continue;
			min = Math.min(min, list[start].get(i));
		}
		if(min != Integer.MAX_VALUE) dfs(min);
	}
	
//	class Node {
//		
//	}

}
