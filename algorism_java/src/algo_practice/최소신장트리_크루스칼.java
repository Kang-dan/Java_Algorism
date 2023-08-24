package algo_practice;

import java.util.*;
import java.io.*;

public class 최소신장트리_크루스칼 {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge (int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
//		 	return Integer.compare(this.weight, o.weight); //방법2 (가중치가 음수가 있을 경우)
		}

	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	
	static int V, E; //노드수, 간선수 
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		//오름차순
		Arrays.sort(edgeList);
		
		//make과정
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
		//union-find과정
		int resultWeight = 0;
		int edgeCnt = 0; //(간선의 수 = 정점수 - 1)
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				resultWeight += edge.weight;
				edgeCnt++;
			}
			if(edgeCnt == V - 1) break;
		}
		
		bw.write(resultWeight+"\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
