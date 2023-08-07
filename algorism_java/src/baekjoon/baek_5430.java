/* AC 5430 어려운점 (오래걸림)
1. 배열 입력 처리 [1,2,3,4] 대괄호와 콤마 빼고 숫자만 가져오기 -> split 복잡. StringTokenizer st = new StringTokenizer(string, "[],"); 이용
2. 배열 뒤집기 대신 -> Deque 이용 (R나오는 개수에 따라 삭제방향(앞,뒤)만 바꾸기)
*/
/*
 * 간단설명 -> Deque, 버퍼입출력, 입력받은 문자열에서 숫자만 가져가기 위해 StringTokenizer사용 
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections; //이건 사용안함 (역방향으로 사용할 때. 덱은 지원안하는듯)
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_5430 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		int T = sc.nextInt(); //테케수 입력 -> 스캐너 
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String P = br.readLine(); //RD입력 
//			int n = sc.nextInt(); //배열 원소개수 -> 스캐너 
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer N = new StringTokenizer(br.readLine(), "[],");; //[배열 원소] 입력 
//			String N = br.readLine(); //[배열 원소] 입력  -> []랑 , 처리하기 위해 위처럼 해줌.
			
			/**배열 원소 숫자만 가져와서 큐에 넣어주기*/ 
			Deque<Integer> list = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				list.add(Integer.parseInt(N.nextToken()));
			}

			/**R,D 함수 해결하기 (R이 홀수번이면 뒤에꺼 제거, R이 짝수번이면 앞에꺼 제거)*/
			int rCnt = 0; //R이 나오는 갯수
			int error = 0; //덱 비어있는데 D나올 때 error출력 확인 플래그 
			for(int i = 0; i < P.length(); i++) { //R,D입력갯수만큼 반복 
				if(P.charAt(i) == 'R') {
					rCnt++;
				} else { // 'D' 
					if(list.size() == 0) { //덱비어있는데 D나오면 error 
						error++;
						break;
					}
					if(rCnt % 2 == 0) { //'R'이 짝수개수만큼 나오면 정방향 삭제 
						list.removeFirst(); 
					} else {
						list.removeLast(); //홀수개면 역방향 삭제 
					}
				}
			}
			if(error != 0) { //에러 
//				System.out.println("error"); ->스캐너
				bw.write("error");
				bw.newLine();
			} else {
				if(list.isEmpty()) { // -> 이부분은 주어진 테케에 없는 경우 (히든테케) 
					bw.write("[]");
					bw.newLine();
				} else {
					if (rCnt % 2 == 0) { // 정방향('R'이 짝수개)
						bw.write("[" + list.pollFirst()); //removeFirst()는 없을경우 예외발생으로 NoSuchElementException 반환, pollFirst()는 null반 
						while (!list.isEmpty()) {
							bw.write("," + list.pollFirst());
						}
						bw.write("]");
						bw.newLine();
					} else { // 역방향 ('R'이 홀수개)
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
		bw.flush(); // 한번에 출력 
		bw.close();
	}

}