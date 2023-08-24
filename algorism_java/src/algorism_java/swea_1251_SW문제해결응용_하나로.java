/*
 * 크루스칼 풀이 
 */
package algorism_java;

import java.util.*;
import java.io.*;

public class swea_1251_SW문제해결응용_하나로 {
	
	static class Edge implements Comparable<Edge> {
		int from, to; //좌표라서 2차월 배열 
		double weight;
		
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight); //double로 반환할때 이렇게 해야함 
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	static int landCnt; //섬의 개수 = 정점 수 
	static double greenPay; //환경부담세율 실수 
	static int[][] map; //섬의 좌표
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			landCnt = Integer.parseInt(br.readLine()); //섬의 개수 (정점 수)
			map = new int[landCnt][2];
			st = new StringTokenizer(br.readLine()); //x좌표
			for(int i = 0; i < landCnt; i++) map[i][1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()); //y좌표 
			for(int i = 0; i < landCnt; i++) map[i][0] = Integer.parseInt(st.nextToken());
			
			greenPay = Double.parseDouble(br.readLine()); //곱해줘야할 실수 
			
			edgeList = new Edge[landCnt * (landCnt-1) / 2]; //간선 수만큼 
			int cnt = 0;
			//edgeList로 좌표, 가중치 넣어주기
			for(int i = 0; i < landCnt; i++) {
				for(int j = 1; j < landCnt; j++) {
					if(i >= j) continue;
					double length = Math.pow(Math.abs(map[i][1]-map[j][1]), 2) + Math.pow(Math.abs(map[i][0]-map[j][0]), 2);
					edgeList[cnt++] = new Edge(i, j, length * greenPay);//정점1(x,y좌표)	, 정점2(x,y좌표), 가중치 	
				}
			}
			
			//가중치 중심 오름차순 정렬
			Arrays.sort(edgeList);
			
			//make과정
			parents = new int[landCnt]; //정점 수 만큼 
			for(int i = 0; i < landCnt; i++) parents[i] = i;
			
			//union과정 
			double resultPay = 0;
			int edgeCnt = 0;
			for(Edge v : edgeList) {
				if(union(v.from, v.to)) {
					resultPay += v.weight;
					edgeCnt++;
				}
				if(edgeCnt == landCnt - 1) break;
			}
			
			bw.write(String.format("#%d %.0f\n", test, resultPay));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
