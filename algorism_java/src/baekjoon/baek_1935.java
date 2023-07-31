package baekjoon;

import java.util.Scanner;

public class baek_1935 {
	static int N; //피연산자의 개수 
	static int[] num = new int[26]; ; //피연산자별 
	static int cnt = 0; //피연산자별 숫자 대조할 때 필요 
	
	//계산 
	public static double pop(double left, char operator, double right) {
		double result = 0;
		switch (operator) {
			case '*' : result = left * right;
			break;
			case '+' : result = left + right;
			break;
			case '-' : result = left - right;
			break;
			case '/' : result = left / right; 
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력 
		N = sc.nextInt();
		String back = sc.next(); //후위표기식 입력 
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt(); //피연산자별 값 (A~Z 차례대로)
		}
		
		//pop push 과정 
		int i=0, flag=0; //flag는 늘 저장된 곳 다음 칸을 가리킴 
		double[] stack = new double[back.length()]; //후위 연산자 계산 및 담을 공간 (char보다 double이 더 크니까)
		for(i=0; i<back.length(); i++) {
			if( 'A'<= back.charAt(i) && back.charAt(i) <='Z') { //피연산자이면 push 
				stack[flag++] = num[back.charAt(i) - 'A'];
			} else { //연산자이면 2개 pop하고, 계산 후 다시 push
				stack[flag-2] = pop(stack[flag-2],back.charAt(i), stack[flag-1]);
				stack[flag-1] = 0; //초기화
				flag--;
			}
		}
		System.out.printf("%.2f",stack[0]);
	
	}
}
