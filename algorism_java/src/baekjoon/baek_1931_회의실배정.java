package baekjoon;

import java.util.*;
import java.io.*;
public class baek_1931_회의실배정 {
	
	static int cnt = 1; //회의 최대 개수 
	static int talkCnt;
	static int[][] talk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		talkCnt = Integer.parseInt(br.readLine());
		talk = new int[talkCnt][2];
		for(int i = 0; i < talkCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			//끝나는 시간 기준 정렬을 위해서 배열 순서 다르게 넣어주기 
			talk[i][1] = Integer.parseInt(st.nextToken());
			talk[i][0] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(talk, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
			
		}); //끝나는 시간이 빠른 순으로 정렬
		
		search(0, talk[0][0]); //끝나는 시간 인덱스, 끝시간 		
		bw.write(cnt+"\n");
		
		bw.close();
		br.close();
		
	}
	
	private static void search(int eIndex, int end) {
		for(int i = eIndex+1; i < talkCnt; i++) {
			if(end <= talk[i][1]) { //끝나는 시간 이후 가까운 시작시간 찾기 
				cnt++;
				search(i, talk[i][0]);
				return;
			}
		}
	}

}
