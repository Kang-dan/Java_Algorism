package baekjoon;

import java.util.Scanner;

public class baek_17478 {
	static int  N; // 재귀호출 횟수 
	public static int ending(int n) { //라고 답변하셨지 
		for(int i=n; i<N; i++) System.out.print("____");
		System.out.println("라고 답변하였지.");
		if(n==N) return 0;
		return ending(n+1);
	}
	
	public static int ask(int n) { //재귀함수가 뭔가요, 재귀함수는~라네, 잘들어보게~물었어.
		for(int i=n; i<N; i++) System.out.print("____");
		System.out.println("\"재귀함수가 뭔가요?\"");
		if(n==0) {
			for(int i=n; i<=N-1; i++) System.out.print("____");
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			ending(0);
			return 0;
		}
		for(int i=n; i<N; i++) System.out.print("____");
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for(int i=n; i<N; i++) System.out.print("____");
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for(int i=n; i<N; i++) System.out.print("____");
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		return ask(n-1);
	}

	public static void main(String[] args) { // 첫 마디 시작 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //재귀 호출 횟수 입력 
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		ask(N);
	}
}
