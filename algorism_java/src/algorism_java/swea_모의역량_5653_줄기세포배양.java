//package algorism_java;
//
//import java.util.*;
//import java.io.*;
//
//public class swea_모의역량_5653_줄기세포배양 {
//
//    static int N, M, time; //초기 세포가 분포된 세로, 가로, 배양시간
//    static int resultCnt; //최종 살아있는 줄기세포 (비활성 상태 + 활성 상태)
//    static int midY = 200, midX = 200;
//    static int[][] sepoMap; //세포 맵
//    static int[][] flag; //활동상태 맵
//    static int[][] liveTime; //생명력 수치 맵(살수있는 시간) (-> 복제받을 때 시간 + 원래 생명수치로 지정 -> 지정받은 시간이 될 때 새로 반복
//    static int[][] birthTime;
//    static Queue<int[]> nonActive; //비활성상태
//    static Queue<int[]> active; //활성상태
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int tCnt = Integer.parseInt(br.readLine());
//        for (int test = 1; test <= tCnt; test++) {
//            resultCnt = 0; //결과 초기화
//
//            st = new StringTokenizer(br.readLine());
//
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//            time = Integer.parseInt(st.nextToken());
//
//            sepoMap = new int[400][400];
//            flag = new int[400][400];
//            liveTime = new int[400][400];
//            birthTime = new int[400][400];
//            
//            nonActive = new ArrayDeque<>();
//            active = new ArrayDeque<>();
//
//            for (int i = midY; i < midY + N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = midX; j < midX + M; j++) {
//                    sepoMap[i][j] = Integer.parseInt(st.nextToken());
//
//                    liveTime[i][j] = sepoMap[i][j];
//                }
//            }
//
//            int[] dy = {0, 1, 0, -1};
//            int[] dx = {1, 0, -1, 0};
//
//            for (int t = 1; t <= time; t++) {
//                // 비활성 상태 세포 큐에 추가
//                for (int[] cell : nonActive) {
//                    int i = cell[0];
//                    int j = cell[1];
//                    if (liveTime[i][j] == t && flag[i][j] == 0) {
//                        flag[i][j] = 1;
//                        active.add(new int[]{i, j});
//                    }
//                }
//                nonActive.clear(); // 비활성 상태 큐 비우기
//
//                // 활성 상태 세포 큐에 추가
//                for (int[] cell : active) {
//                    int i = cell[0];
//                    int j = cell[1];
//                    if (liveTime[i][j] + 1 == t) {
//                        for (int d = 0; d < 4; d++) {
//                            int ni = i + dy[d];
//                            int nj = j + dx[d];
//                            if (sepoMap[ni][nj] == 0 && flag[ni][nj] == 0) {
//                                nonActive.add(new int[]{ni, nj});
//                            }
//                        }
//                    }
//                }
//                active.clear(); // 활성 상태 큐 비우기
//
//                // 생명력 갱신 및 번식
//                for (int i = 0; i < 400; i++) {
//                    for (int j = 0; j < 400; j++) {
//                        if (liveTime[i][j] == t && flag[i][j] == 0) flag[i][j] = 1;
//
//                        if ((flag[i][j] == 1) && (liveTime[i][j] + 1 == t)) {
//                            for (int d = 0; d < 4; d++) {
//                                int ni = i + dy[d];
//                                int nj = j + dx[d];
//                                if (sepoMap[ni][nj] == 0 && flag[ni][nj] != 0) continue;
//                                if (sepoMap[ni][nj] != 0 && birthTime[ni][nj] > birthTime[i][j]) continue;
//
//                                if (sepoMap[i][j] > sepoMap[ni][nj]) {
//                                    liveTime[ni][nj] = t + sepoMap[i][j];
//                                    sepoMap[ni][nj] = sepoMap[i][j];
//                                    birthTime[ni][nj] = t;
//                                    nonActive.add(new int[]{ni, nj}); // 번식한 세포를 비활성 상태 큐에 추가
//                                }
//                            }
//                            if (liveTime[i][j] + sepoMap[i][j] == t) sepoMap[i][j] = 0;
//                        }
//                    }
//                }
//            }
//
//            // 최종 살아있는 줄기세포 비활성상태 + 활성상태 (= 세포맵에서 0이 아닌경우)
////            for (int i = 0; i < 400; i++) {
////                for (int j = 0; j < 400; j++) {
////                    if (sepoMap[i][j] != 0) resultCnt++;
////                }
////            }
//            resultCnt = nonActive.size() + active.size();
//
//            bw.write(String.format("#%d %d\n", test, resultCnt));
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}


package algorism_java;

import java.util.*;
import java.io.*;

public class swea_모의역량_5653_줄기세포배양 {
	
	static int N, M, time; //초기 세포가 분포된 세로, 가로, 배양시간 
	static int resultCnt; //최종 살아있는 줄기세포 (비활성 상태 + 활성 상태)
	static int midY = 200, midX = 200;
	static int[][] sepoMap; //세포 맵 
	static int[][] flag; //활동상태 맵
	static int[][] liveTime; //생명력 수치 맵(살수있는 시간) (-> 복제받을 때 시간 + 원래 생명수치로 지정 -> 지정받은 시간이 될 때 새로 반복 
	static int[][] birthTime;
	static Queue<int[]> nonActive = new ArrayDeque<>(); //비활성상태 
	static Queue<int[]> active= new ArrayDeque<>(); //활성상태 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tCnt; test++) {
			resultCnt = 0; //결과 초기화 
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			
			sepoMap = new int[400][400];
			flag = new int[400][400];
			liveTime = new int[400][400];
			birthTime = new int[400][400];
			
			for(int i = midY; i < midY+N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = midX; j < midX + M; j++) {
					sepoMap[i][j] = Integer.parseInt(st.nextToken());
					
					liveTime[i][j] = sepoMap[i][j];
				}
			}
			
			int[] dy = {0, 1, 0, -1};
			int[] dx = {1, 0, -1, 0};
			
			for(int t = 1; t <= time; t++) {
				for(int i = 0; i < 400; i++) {
					for(int j = 0; j < 400; j++) {
						//현재시간 = 생명시간이면 활성상태 1 
						if(liveTime[i][j] == t && flag[i][j] == 0) flag[i][j] = 1; //현재시간 같은 세포는 활성상태 1로 
						
						//현재시간 = 생명시간 + 1이면 사방번식(생명시간 = 현재시간 + 기존맵 시간) + 번식시킨 세포는 죽음(기존세포맵 = 0)
						//사방번식 때 플래그0이고 생명시간이 자신보다 작을 때에만 번식 
						if((flag[i][j] == 1) && (liveTime[i][j] + 1 == t)) {
							for(int d = 0; d < 4; d++) {
								if(sepoMap[i + dy[d]][j + dx[d]] == 0 && flag[i + dy[d]][j + dx[d]] != 0) continue; //이미 세포 죽은 상태면 스킵 (세포맵은 0인데 활동상태는 1이면 죽은상태)
//								if(sepoMap[i + dy[d]][j + dx[d]]!= 0 && flag[i + dy[d]][j + dx[d]] != 0) continue;
								if(sepoMap[i + dy[d]][j + dx[d]] != 0 && birthTime[i + dy[d]][j + dx[d]] > birthTime[i][j]) continue;
								
								if(sepoMap[i][j] > sepoMap[i + dy[d]][j + dx[d]]) {
									liveTime[i + dy[d]][j + dx[d]] = t + sepoMap[i][j]; //사방번식세포 생명시간 = 현재시간 + 기존 세포맵시간 
									sepoMap[i + dy[d]][j + dx[d]] = sepoMap[i][j]; //세포맵 상태 업데이트 
									birthTime[i + dy[d]][j + dx[d]] = t;
								}
							}
							if(flag[i][j] == 1 && liveTime[i][j] + sepoMap[i][j] == t) sepoMap[i][j] = 0; //번식시킨 세포는 죽음
						}
						
					}
				}
			}
			
			//최종 살아있는 줄기세포 비활성상태 + 활성상태 (= 세포맵에서 0이 아닌경우)
			for(int i = 0; i < 400; i++) {
				for(int j = 0; j < 400; j++) {
					if(sepoMap[i][j] != 0) resultCnt++;
				}
			}
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
