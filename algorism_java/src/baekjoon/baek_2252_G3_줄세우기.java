/*
 * 위상정렬 (인접리스트) 
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_2252_G3_줄세우기 {

	static int sCnt, compareCnt;
	static ArrayList<Integer>[] aList;
	static int[] inDegree;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		sCnt = Integer.parseInt(st.nextToken());
		compareCnt = Integer.parseInt(st.nextToken());
		
		aList = new ArrayList[sCnt + 1];
		inDegree = new int[sCnt + 1]; //진입차수 
		
		for(int i = 1; i <= sCnt; i++) {
			aList[i] = new ArrayList<>(); //어레이리스트 초기화 
		}
		
		for(int i = 0; i < compareCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			aList[out].add(in);
			inDegree[in]++; //진입차수 증가 
		}
		
		bfsSort();
		
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static void bfsSort() throws IOException {
		Queue<Integer> q = new ArrayDeque<>();
		//진입차수 0인 노드 큐에 넣기 
		for(int i = 1; i <= sCnt; i++) {
			if(inDegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			bw.write(node + " ");
			
			//node가 가리키는 방향의 노드들의 진입차수 감소하기 
			for(int v : aList[node]) {
				if(--inDegree[v] == 0) {
					q.offer(v);
				}
			}
			
			/* 이렇게도 가능 
			for(int i = 0; i < aList[node].size(); i++) {
				int v = aList[node].get(i);
				if(--inDegree[v] == 0) {
					q.offer(v);
				}
			}
			*/
		}
		
	}
	

}
