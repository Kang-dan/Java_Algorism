/*
 * 힙 구현을 위해 PriorityQueue(우선순위큐) 사용
 * 자바는 기본적으로 오름차순으로 이루어져 있음 
 * PriorityQueue의 정렬기준을 새로 만들어주기 위해 Comparator - compare(메소드에 두개의 객체를 전달, int를 반환)를 오버라이딩
 * 아래 코드는 람다식으로 작성 
 * 
 * compare 오버라이딩 
 * 반환값이 음수(-1)이면 첫번째 매개변수가 두 번째 매개변수보다 우선순위가 높다는 것
 * 반환값이 0이면 두 원소의 우선순위가 같다는 것. (두 원소의 순서는 상관없이 현재 순서가 유지)
 * 반환값이 양수(1)이면 첫번째 매개변수가 두 번째 매개변수보다 우선순위가 낮다는 것. (첫번째 원소가 두번째 원소보다 뒤에 위치)
 * 
 * compare값으로 양수를 주면 순서를 바꾸겠다는 것. 음수면 바꾸지 않겠다는 것. 
 * 절댓값 Math.abs() 사용 
 *
 */
package baekjoon;

import java.util.*;
import java.io.*;

public class baek_11286_절댓값힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		//원래는 정수나 문자의 경우 낮은 값이 높은 값보다 우선함. 
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			if(a == b) return (o1 > o2)? 1 : -1; //절댓값이 같으면 원래 값 비교 
			else if(a < b) return -1;
			else return 1;
		});
		
		for(int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(heap.isEmpty()) {
					bw.write("0\n");
					continue;
				} else bw.write(heap.remove()+"\n");
			}
			
			if(num != 0) heap.offer(num);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
