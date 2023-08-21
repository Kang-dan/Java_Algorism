/*
 * 위상정렬 (인접리스트)
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_G3_2623_음악프로그램 {

	static int singCnt, pdCnt;
	static int[] inDegree;
	static ArrayList<Integer>[] aList;
	static int[] outCnt; //출력하는 노드의 수가 기존 노드의 수와 다르면 사이클 있음 (순서 정하는게 불가능) 
	static int cnt;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		singCnt = Integer.parseInt(st.nextToken());
		pdCnt = Integer.parseInt(st.nextToken());
		
		inDegree = new int[singCnt + 1];
		outCnt = new int[singCnt];
		
		aList = new ArrayList[singCnt + 1];
		for(int i = 1; i <= singCnt; i++) {
			aList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < pdCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int pdSingCnt = Integer.parseInt(st.nextToken());
			
			int[] ps = new int[pdSingCnt];
			for(int j = 0; j < pdSingCnt; j++) {
				ps[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < pdSingCnt; j++) {				
				for(int k = j+1; k < pdSingCnt; k++) {
					aList[ps[j]].add(ps[k]);
					inDegree[ps[k]]++;
				}
			}
		}
		
		bfsSort();
		
		if(cnt != singCnt) bw.write("0");
		else {
			for(int i = 0; i < outCnt.length; i++) {
				bw.write(outCnt[i]+"\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfsSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		//진입차수 0이면 큐에 넣기
		for(int i = 1; i <= singCnt; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int out = q.poll();
			outCnt[cnt++] = out;
			
			//v와 연결된 노드의 진입차수 하나 감소 
			for(int v : aList[out]) {
				if(--inDegree[v] == 0) q.offer(v);
			}
		}
	}

}
