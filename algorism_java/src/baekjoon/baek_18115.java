/* 백준18115. 카드놓기 
 * 1. 배열[N+1] 1~N까지
 * 2. 배열에서 flag역할 2개 : second : 2번규칙 , last : 3번 규칙 
 * 
 *[규칙]
1. 제일 위의 카드 1장을 바닥에 내려놓는다.
2. 위에서 두 번째 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
3. 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
 * 
 * [간단설명]
 * 1. 입력받은 수 역순으로, Deque 이용 
 * 2. 출력값을 입력값 순서대로하면 5 4 3 2 1 순서가 나와야 함.
 * 3. Scanner는 시간초과남 -> 버퍼이용 (reader, writer) 
 * 4. "1 3 5 7" 식으로 공란 포함 String Line일시 StringTokenizer 이용
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//import java.util.Arrays;
//import java.util.Scanner;

public class baek_18115 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer a;

		int N = Integer.parseInt(bf.readLine());
		Deque<Integer> card = new ArrayDeque<>();
		
//		a = new StringTokenizer(bf.readLine()); // 수열 입력 (입력 순서대로 하는 방법은 모르겠음)
		a = new StringTokenizer(new StringBuilder(bf.readLine()).reverse().toString()); //역순으로 
		int count = 1;
		for(int i = 0; i < N; i ++) {
			int b = Integer.parseInt(a.nextToken());
			if(b == 1) { //규칙 1
				card.addFirst(count);
			} else if (b == 2) { //규칙 2 
				int temp = card.removeFirst();
				card.addFirst(count);
				card.addFirst(temp);
			} else { //규칙 3
				card.addLast(count);
			}
			count++;
        }
		
		for(int i : card) {
			bw.write(i + " "); //bw.write에 입력받고 
		}
		bw.flush(); //한번에 출력 
		bw.close();
	}
	
}

/* 입력받은 순서대로 해결해려다 실패 
		int N = Integer.parseInt(bf.readLine());
		int[] card = new int[N+1];
		int count = N; //N부터 1씩 차감 (역카운트) 
		int first = 1; //규칙1 
		int second = 2; // 배열인덱스 2부터 올라감(규칙 2)
		int last = N; // 배열 인덱스 마지막부터 내려감(규칙3)
		
	
		a = new StringTokenizer(bf.readLine()); // 수열 입력 
		for(int i = 0; i < N; i ++) {
			int b = Integer.parseInt(a.nextToken());
			if(b == 2) { //2번 규칙 
				card[second++] = count--;
			} else if (b == 3){ //3번 규칙 
				card[last--] = count--;
			} else { //1번 규칙 
				if(card[1] == 0) {
					card[first++] = count--;
				} else {
					card[second++] = count--;
				}
			}
		}
	
		for(int i = 1; i <= N; i ++) {
			bw.write(card[i]+" ");
		}
		bw.flush();
		bw.close();
		*/


/* Scanner 사용 -> 시간초과 
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] card = new int[N+1]; //1~N 최종 출력할 배열 
	
	int count = N; //N부터 1씩 차감 (역카운트) 
	int first = 1; //규칙1 
	int second = 2; // 배열인덱스 2부터 올라감(규칙 2)
	int last = N; // 배열 인덱스 마지막부터 내려감(규칙3)
	for(int i = 0; i < N; i ++) {
		int a = sc.nextInt(); //수열 입력 
		if(a == 2) { //2번 규칙 
			card[second++] = count--;
		} else if (a == 3){ //3번 규칙 
			card[last--] = count--;
		} else { //1번 규칙 
			card[first++] = count--;
		}
	}
	for(int i = 1; i <= N; i ++) {
		System.out.print(card[i]+" ");
	}
*/