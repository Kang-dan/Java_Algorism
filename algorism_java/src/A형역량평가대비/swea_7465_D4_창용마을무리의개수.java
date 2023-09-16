package A형역량평가대비;

import java.util.*;
import java.io.*;

public class swea_7465_D4_창용마을무리의개수 {

	static boolean[] visit; // 방문체크 
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n + 1];
			for(int i = 1; i <= n; i++) list[i] = new ArrayList<Integer>();
			
			visit = new boolean[n + 1];//1~n
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				list[end].add(start); //양방향이라는걸 잊지말자..!!!
			}
			
			int resultCnt = 0;
			for(int i = 1; i <= n; i++) {
				if(!visit[i]) {
					bfs(i);
					resultCnt++;
				}
			}
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();

			for(int i = 0; i < list[n].size(); i++) {
				if(!visit[list[n].get(i)]) {
					q.offer(list[n].get(i));
					visit[list[n].get(i)] = true;
				}
			}
		}
	}

}



/**내가 푼 다른 풀이


 // 1~N명
 // 몇개의 집합이 존재하는지  (대표자가 몇명인지 찾기) union으로 find불러서 같은 값이면 증가 
import java.util.*;
import java.io.*;

public class Solution {

	static int[] parents;
	static int[] parents2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			int resultCnt = 0; //최종 결과 무리수 
			
			st = new StringTokenizer(br.readLine());
			
			int personCnt = Integer.parseInt(st.nextToken()); //마을 사람 수 
			int knowCnt = Integer.parseInt(st.nextToken()); //알고있는 관계 수
			parents = new int[personCnt+1];
			parents2 = new int[personCnt+1];
			
			//make 처리 (자기자신이 부모노드)W
			for(int i = 1; i <= personCnt; i++) {
				parents[i] = i; 
				parents2[i] = i;
			}
			
			for(int i = 0; i < knowCnt; i++) {
				st = new StringTokenizer(br.readLine());
				
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				
				union(one, two); //서로 같은 집합 만들어주기 
			}
			
			
			for(int i = 1; i <= personCnt; i++) {
				if(parents[i] == i) resultCnt++;
			}
			
			bw.write("#"+test+" "+resultCnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]); //경로
		
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a); //a 집합의 대표자 
		int bRoot = find(b); //b집합의 대표자
		
		if(aRoot == bRoot) return;
		parents[aRoot] = bRoot; //같은 집합 만들어주기 
		return;
	}

}

**/