// 인구차이의 최솟값 
package A형역량평가대비;

import java.util.*;
import java.io.*;

public class BJ_G4_17471_게리맨더링 {

	static int N;
	static int[] pCnt;
	static ArrayList<Integer>[] list;
	static int[] area1;
	static int[] area2;
//	static int[] input;
	static int pSum, resultMin;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//입력받기 (인구수, 연결지역 리스트)
		N = Integer.parseInt(br.readLine()); //구역 개수
		pCnt = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			pCnt[i] = Integer.parseInt(st.nextToken()); //인구
			pSum += pCnt[i]; //전체인구수 
		}
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= a; j++) {
				list[i].add(Integer.parseInt(st.nextToken())); //연결된 지역 
			}
		}
		
		area1 = new int[N+1];
		area2 = new int[N+1];
		//조합 (선택된 배열, 선택안된 배열 2개로 나누기)
		resultMin = Integer.MAX_VALUE;
		for(int i = 1; i <= N/2; i++) {
			combination(i, 0, 0); //선택개수, 현재 선택개수 , start
		}
		
		if(resultMin == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(resultMin+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void combination(int select, int cnt, int start) {
		if(cnt == select) {
			//area2배열에 값 넣어주기 
			int pSum1 = 0;
			int pSum2 = 0;
			for(int i = 1; i <= N; i++) {
				if(area1[i] == 0) {
					pSum2 += pCnt[i];
					area2[i] = i; //area1이 선택이 안되어있으면 area2에 값 넣어주기 
				}
			}
			//각각 배열이 연결되어있는지 확인하기 (연결안되어있으면 갱신없이 리턴)
			if(check(select)) { //선택개수 
				//연결되어있으면 인구수 차이가 최소인지 확인 (최소로 갱신)
				pSum1 = pSum - pSum2;
				resultMin = Math.min(resultMin, Math.abs(pSum1 - pSum2));
				System.out.println("area1: "+ Arrays.toString(area1));
				System.out.println("area2: "+ Arrays.toString(area2));
			}
			
			Arrays.fill(area1,0);
			Arrays.fill(area2,0);
			return;
		}
		
		for(int i = start; i <= N; i++) {
			area1[cnt] = i; //1부터 시작 
			combination(select, cnt + 1, i + 1);
//			area1[i] = 0;
		}
	}
	
//	
//	private static boolean check(int[] areas) {
//	    boolean[] visited = new boolean[N + 1];
//	    Queue<Integer> queue = new LinkedList<>();
//
//	    // 첫 번째 구역을 시작점으로 BFS 탐색
//	    for(int area : areas) {
//	    	queue.offer(area);
//	    	visited[area] = true;
//	    }
//
//	    int connectedCount = areas.length;
//
//	    while (!queue.isEmpty()) {
//	        int current = queue.poll();
//
//	        for (int neighbor : list[current]) {
//	            if (!visited[neighbor] && contains(areas, neighbor)) {
//	                visited[neighbor] = true;
//	                queue.offer(neighbor);
//	                connectedCount++;
//	            }
//	        }
//	    }
//
//	    // 연결된 구역의 개수와 선택한 구역의 개수가 일치해야 연결되었다고 판단
//	    return connectedCount == areas.length;
//	}
//
//	private static boolean contains(int[] areas, int target) {
//	    for (int area : areas) {
//	        if (area == target) {
//	            return true;
//	        }
//	    }
//	    return false;
//	}


	private static boolean check(int select) {
//		Queue<Integer> q = new ArrayDeque<>();
		//area1, area2 연결확인 
		boolean[] a = new boolean[N+1];
		boolean[] b = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			if(area1[i] != 0) {
				for(int j = 1; j <= list[i].size(); j++) {
					a[list[i].get(j-1)] = true;
				}
				
			}
		}
//		System.out.println(Arrays.toString(a));
		
		for(int i = 1; i <= N; i++) {
			if((area1[i]!=0 && a[i]==false)) return false;
		}
		
		for(int i = 1; i <= N; i++) {
			if(area2[i] != 0) {
				for(int j = 1; j <= list[i].size(); j++) {
					b[list[i].get(j-1)] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(a));
		
		//확인 
		for(int i = 1; i <= N; i++) {
			if(area2[i]!=0 && b[i]==false) return false;
		}
		
		return true;
	}

}







/*
 
 // 인구차이의 최솟값 
package A형역량평가대비;

import java.util.*;
import java.io.*;

public class BJ_G4_17471_게리맨더링 {

	static int N;
	static int[] pCnt;
	static ArrayList<Integer>[] list;
	static int[] area1;
	static int[] area2;
//	static int[] input;
	static int pSum, resultMin;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//입력받기 (인구수, 연결지역 리스트)
		N = Integer.parseInt(br.readLine()); //구역 개수
		pCnt = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			pCnt[i] = Integer.parseInt(st.nextToken()); //인구
			pSum += pCnt[i];
		}
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= a; j++) {
				list[i].add(Integer.parseInt(st.nextToken())); //연결된 지역 
			}
		}
		
		area1 = new int[N+1];
		area2 = new int[N+1];
		//조합 (선택된 배열, 선택안된 배열 2개로 나누기)
		resultMin = Integer.MAX_VALUE;
		for(int i = 1; i <= N/2; i++) {
			combination(i, 0, 0); //선택개수, 현재 선택개수 , start
		}
		
		if(resultMin == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(resultMin+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void combination(int select, int cnt, int start) {
		if(cnt == select) {
			//area2배열에 값 넣어주기 
			int pSum1 = 0;
			int pSum2 = 0;
			for(int i = 1; i <= N; i++) {
				if(area1[i] == 0) {
					pSum2 += pCnt[i];
					area2[i] = i; //area1이 선택이 안되어있으면 area2에 값 넣어주기 
				}
			}
			//각각 배열이 연결되어있는지 확인하기 (연결안되어있으면 갱신없이 리턴)
			if(check(select)) { //선택개수 
				//연결되어있으면 인구수 차이가 최소인지 확인 (최소로 갱신)
				pSum1 = pSum - pSum2;
				resultMin = Math.min(resultMin, Math.abs(pSum1 - pSum2));
			}
			
			Arrays.fill(area1,0);
			Arrays.fill(area2,0);
			return;
		}
		
		for(int i = start; i <= N; i++) {
			area1[i] = i; //1부터 시작 
			combination(select, cnt + 1, i + 1);
//			area1[i] = 0;
		}
	}
	
//	
//	private static boolean check(int[] areas) {
//	    boolean[] visited = new boolean[N + 1];
//	    Queue<Integer> queue = new LinkedList<>();
//
//	    // 첫 번째 구역을 시작점으로 BFS 탐색
//	    for(int area : areas) {
//	    	queue.offer(area);
//	    	visited[area] = true;
//	    }
//
//	    int connectedCount = areas.length;
//
//	    while (!queue.isEmpty()) {
//	        int current = queue.poll();
//
//	        for (int neighbor : list[current]) {
//	            if (!visited[neighbor] && contains(areas, neighbor)) {
//	                visited[neighbor] = true;
//	                queue.offer(neighbor);
//	                connectedCount++;
//	            }
//	        }
//	    }
//
//	    // 연결된 구역의 개수와 선택한 구역의 개수가 일치해야 연결되었다고 판단
//	    return connectedCount == areas.length;
//	}
//
//	private static boolean contains(int[] areas, int target) {
//	    for (int area : areas) {
//	        if (area == target) {
//	            return true;
//	        }
//	    }
//	    return false;
//	}


	private static boolean check(int select) {
//		Queue<Integer> q = new ArrayDeque<>();
		//area1, area2 연결확인 
		boolean[] a = new boolean[N+1];
		boolean[] b = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			if(area1[i] != 0) {
				for(int j = 1; j <= select; j++) {
					if(list[area1[i]].size() >= j)
						a[list[area1[i]].get(j-1)] = true;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if((area1[i]!=0 && a[i]==false)) return false;
		}
		
		for(int i = 1; i <= N; i++) {
			if(area2[i] != 0) {
				for(int j = 1; j <= N-select; j++) {
					if(list[area2[i]].size() >= j)
						b[list[area2[i]].get(j-1)] = true;
				}
			}
		}
		
		//확인 
		for(int i = 1; i <= N; i++) {
			if(area2[i]!=0 && b[i]==false) return false;
		}
		
		return true;
	}

}

 
 */
