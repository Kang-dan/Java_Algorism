/*
 * AC규칙 
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_5430 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		int T = sc.nextInt(); //테케수 입력 
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String P = br.readLine(); //RD입력 
//			int n = sc.nextInt(); //배열 원소개수 
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer N = new StringTokenizer(br.readLine(), "[],");; //[배열 원소] 입력 
//			String N = br.readLine(); //[배열 원소] 입력 
			
			//배열 원소 숫자만 가져와서 큐에 넣어주기 
			Deque<Integer> list = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				list.add(Integer.parseInt(N.nextToken()));
			}
//			String[] arr = new String[n];
//			for(int i = 0; i < arr.length; i++) {
//				list.add(arr[i]);
//			}

			//R,D 함수 해결하기 (R이 홀수번이면 뒤에꺼 제거, R이 짝수번이면 앞에꺼 제거)
			int rCnt = 0;
			int error = 0;
			for(int i = 0; i < P.length(); i++) {
				if(P.charAt(i) == 'R') {
					rCnt++;
				} else { // 'D'
					if(list.size() == 0) {
						error++;
						break;
					}
					if(rCnt % 2 == 0) { 
						list.removeFirst(); //정방향 삭제 
					} else {
						list.removeLast(); //역방향 삭제 
					}
				}
			}
			if(error != 0) {
//				System.out.println("error");
				bw.write("error");
				bw.newLine();
			} else {
				if(list.isEmpty()) {
					bw.write("[]");
					bw.newLine();
				} else {
//				String[] result = new String[list.size()];
					if (rCnt % 2 == 0) { // 정방향
						bw.write("[" + list.pollFirst());
						while (!list.isEmpty()) {
							bw.write("," + list.pollFirst());
						}
						bw.write("]");
						bw.newLine();
					} else { // 역방향
						bw.write("[" + list.pollLast());
						while (!list.isEmpty()) {
							bw.write("," + list.pollLast());
						}
						bw.write("]");
						bw.newLine();
					}
					
				}
//				if(rCnt % 2 == 0) { //정방향 
//					bw.write("["+list.peek());
//					list.removeFirst();
//					for(int i = 0; list.size()==0; i++) {
//						bw.write(","+list.peek());
//						list.removeFirst();
//					}
//					bw.write("]");
//				} else { //역방향 
//					bw.write("["+list.peekLast());
//					list.removeLast();
//					for(int i = 0; list.size()==0; i++) {
//						bw.write(","+list.peekLast());
//						list.removeLast();
//					}
//					bw.write("]");
//				}
				
			}
			
			
			
			
		}
		bw.flush();
		bw.close();
	}

}
