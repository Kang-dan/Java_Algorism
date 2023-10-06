package algorism_java;

import java.util.*;
import java.io.*;

public class SWEA_5643_키순서 {

	static int N, M;
	static ArrayList<Integer>[] list1;
	static ArrayList<Integer>[] list2;
	static boolean[][] visit1;
	static boolean[][] visit2;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int tCnt = Integer.parseInt(br.readLine());
	    for(int test = 1; test <= tCnt; test++) {
	        N = Integer.parseInt(br.readLine()); //학생수
	        M = Integer.parseInt(br.readLine()); //비교횟수
	        
	        list1 = new ArrayList[N+1];
	        list2 = new ArrayList[N+1];
	        
	        visit1 = new boolean[N+1][N+1];
	        visit2 = new boolean[N+1][N+1];
	        
	        for(int i = 1; i <= N; i++) {
	        	list1[i] = new ArrayList<>();
	        	list2[i] = new ArrayList<>();
	        }
	        
	        for(int i = 0; i < M; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int a = Integer.parseInt(st.nextToken());
	        	int b = Integer.parseInt(st.nextToken());
	        	
	        	list1[a].add(b);
	        	list2[b].add(a);
	        }
	        
	        int sum = 0;
	        int result = 0;
	        for(int i = 1; i <= N; i++) {
	        	if(list1[i].size() != 0) sum = bfs1(0, i);
	        	if(list2[i].size() != 0) sum += bfs2(0, i);
	        	if(sum == N-1) {
	        		result++;
	        	}
	        	sum = 0;
	        }
	        
	        bw.write(String.format("#%d %d\n", test, result));
	    }
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
	
	private static int bfs1(int cnt, int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < list1[idx].size(); i++) {
			q.offer(list1[idx].get(i));
			visit1[idx][list1[idx].get(i)] = true;
			cnt++;
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i = 0; i < list1[v].size(); i++) {
				if(!visit1[idx][list1[v].get(i)]) {
					q.offer(list1[v].get(i));
					visit1[idx][list1[v].get(i)] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	private static int bfs2(int cnt, int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < list2[idx].size(); i++) {
			q.offer(list2[idx].get(i));
			visit2[idx][list2[idx].get(i)] = true;
			cnt++;
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i = 0; i < list2[v].size(); i++) {
				if(!visit2[idx][list2[v].get(i)]) {
					q.offer(list2[v].get(i));
					visit2[idx][list2[v].get(i)] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}