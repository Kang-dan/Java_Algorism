package baekjoon;
//BJ_2164_카드2 (큐 이용)
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*

Queue
queue.add(); 추가
queue.poll(); 첫번째값 반환하고 제거
queue.remove(); 첫번째값 제거
queue.clear(); queue 초기화
queue.peek(); 첫번째값 참조
Deque */
public class baek_2164 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    Queue<Integer> queue = new LinkedList<>();
	    for(int i = 1; i <= N; i++) {
	        queue.add(i); //큐에 값 넣기
	    }
	    
	    while(queue.size() > 1) {
	        queue.remove(); //삭제 
	        int first = queue.poll(); 
	        queue.add(first); //앞의 원소 뒤로 보내기 
	    }
	   System.out.println(queue.peek());
	}
}