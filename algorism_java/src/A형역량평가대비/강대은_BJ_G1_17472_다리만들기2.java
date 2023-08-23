package A형역량평가대비;

import java.util.*;
import java.io.*;

public class 강대은_BJ_G1_17472_다리만들기2 {

	static int sizeY, sizeX;
	static int[][] map;
	
	//bfs용 
	static boolean[][] isVisit;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int landNum = 0; //섬의 고유번호 지정해주기 
	
	static int[][] LandDistance; //가중치 있는 인접행렬로 
	
	//크루스칼용 
	static Edge[] edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return LandDistance[this.from][this.to] - LandDistance[o.from][o.to]; //가중치
			return this.weight - o.weight;
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		sizeY = Integer.parseInt(st.nextToken());
		sizeX = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[sizeY + 2][sizeX + 2];
		
		map = new int[sizeY + 2][sizeX + 2];
		
		for(int i = 1; i <= sizeY; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= sizeX; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1인 부분 bfs돌고, 각 섬의 고유번호로 바꾸기 (1,2,3,4,5,,,)
		for(int i = 1; i <= sizeY; i++) {
			for(int j = 1; j <= sizeX; j++) {
				if(map[i][j] == 1 && isVisit[i][j] == false) bfs(i, j);
			}
		}
		
		LandDistance = new int[landNum+1][landNum+1];
		
		//가중치 있는 인접행렬 최대값으로 초기화
		for(int i = 1; i <= landNum; i++) {
			Arrays.fill(LandDistance[i], Integer.MAX_VALUE);			
		}
		
		//각 섬 사이 거리 구해주기 & (크루스칼) 인접 노드 연결 
		for(int i = 1; i <= sizeY; i++) {
			for(int j = 1; j <= sizeX; j++) {
				if(map[i][j] != 0) 다른섬까지최소거리(i, j, map[i][j]); //인덱스, 섬 번호
			}
		}
		
		/* 확인용) 섬과 섬 사이 최소거리 인접행렬 
		for(int i = 1; i <= landNum; i++) {
			for(int j = 1; j <= landNum; j++) {
				bw.write(LandDistance[i][j]+" ");
			}
			bw.write("\n");
		}
		*/
		
		//간선 수 세기 
		int edgeCnt = 0;
		for(int from = 1; from <= landNum; from++) {
			for(int to = 1; to <= landNum; to++) {
				if(LandDistance[from][to] != Integer.MAX_VALUE) edgeCnt++;
			}
		}
		edgeCnt /= 2;
		
		//크루스칼 이용 (노드 리스트 만들어주기)
		edgeList = new Edge[edgeCnt];
		
		int cnt = 0;
		boolean[][] visit = new boolean[landNum+1][landNum+1];
		for(int from = 1; from <= landNum; from++) {
			for(int to = 1; to <= landNum; to++) {
				if(!visit[from][to] && LandDistance[from][to] != Integer.MAX_VALUE) {
					visit[from][to] = true;
					visit[to][from] = true;
					edgeList[cnt++] = new Edge(from, to, LandDistance[from][to]);
				}
			}
		}
		
		//간선리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		//make작업 
		parents = new int[landNum + 1];
		for(int i = 0; i <= landNum; i++) { //섬의 개수만큼
			parents[i] = i;
		}
		
		//최소거리 선택해가기 (union, find 작업)
		int resultDistance = 0;
		int landEdgeCnt = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				resultDistance += edge.weight;
				landEdgeCnt++;
			}
		}
		if(landEdgeCnt == landNum - 1) bw.write(resultDistance+"");
		else bw.write("-1");
		
		bw.flush();

	}
	
	//크루스칼 사용 (섬끼리 최소거리 선택해가기) 
	
	
	//전처리2) 양방향 인접행렬 (인접한 섬의 최소거리 구하기) 
	private static void 다른섬까지최소거리(int y, int x, int numLand) {
		// 사방으로 모두 탐색해서 거리가 2이상인 경우 중 최소거리 구하기 -> 구한 후에는 리스트로 넣기 
		int whoNum = 0, distance = 0;
		//오
		for(int i = x+1; i <= sizeX; i++) {
			if(map[y][i] == numLand) distance = 0; //이거 히든테케라 찾기 힘들었음.
			if(map[y][i] != numLand && map[y][i] != 0) {
				whoNum = map[y][i];
				break;
			}
			if(map[y][i] == 0) distance++;
		} if(whoNum != 0 && distance >= 2) {
			//섬과 섬 사이 최소경로 갱신 
			LandDistance[whoNum][numLand] = LandDistance[numLand][whoNum] = Math.min(distance, LandDistance[numLand][whoNum]);
		}
		
		//아
		whoNum = 0;
		distance = 0;
		for(int i = y+1; i <= sizeY; i++) {
			if(map[i][x] == numLand) distance = 0;
			if(map[i][x] != numLand && map[i][x] != 0) {
				whoNum = map[i][x];
				break;
			}
			if(map[i][x] == 0) distance++;
		} if(whoNum != 0 && distance >= 2) {
			LandDistance[whoNum][numLand] = LandDistance[numLand][whoNum] = Math.min(distance, LandDistance[numLand][whoNum]);
		}
		
		//왼
		whoNum = 0;
		distance = 0;
		for(int i = x-1; i >= 0; i--) {
			if(map[y][i] == numLand) distance = 0;
			if(map[y][i] != numLand && map[y][i] != 0) {
				whoNum = map[y][i];
				break;
			}
			if(map[y][i] == 0) distance++;
		} if(whoNum != 0 && distance >= 2) {
			LandDistance[whoNum][numLand] = LandDistance[numLand][whoNum] = Math.min(distance, LandDistance[numLand][whoNum]);
		}
		
		//위
		whoNum = 0;
		distance = 0;
		for(int i = y-1; i >= 0; i--) {
			if(map[i][x] == numLand) distance = 0;
			if(map[i][x] != numLand && map[i][x] != 0) {
				whoNum = map[i][x];
				break;
			}
			if(map[i][x] == 0) distance++;
		} if(whoNum != 0 && distance >= 2) {
			LandDistance[whoNum][numLand] = LandDistance[numLand][whoNum] = Math.min(distance, LandDistance[numLand][whoNum]);
		}
	}
	
	
	//전처리2) 섬의 개수 파악 및 섬의 고유번호 만들어주기 
	private static void bfs(int y, int x) {
		landNum++; //섬의 고유번호 넣어주기 (최종 값이 섬의 개수 )
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		isVisit[y][x] = true;
		
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int a = v[0];
			int b = v[1];
			map[a][b] = landNum; //섬의 고유번호 넣어주기 (1부터 시작)
			
			for(int d = 0; d < 4; d++) {
				if(isVisit[a + dy[d]][b + dx[d]] == false && map[a + dy[d]][b + dx[d]] == 1) {
					q.offer(new int[] {a + dy[d], b + dx[d]});
					isVisit[a + dy[d]][b + dx[d]] = true;
				}
			}
		}
	}
	
	

}
