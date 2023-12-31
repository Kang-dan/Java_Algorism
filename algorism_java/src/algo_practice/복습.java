package algo_practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

//그주 워크샵, 과제 등등 배운내용 복습하는 다요리 


public class 복습 {
	static int N,R;
	static int[] numbers;
	static int[] input;
	static boolean[] isSelected;
	
	static char[] bfsData = {' ','a','b','c','d','e','f','g','h','i','j','k'};
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		R = sc.nextInt();
//		numbers = new int[R]; //최종 출력 
//		input = new int[N];
//		for(int i = 0; i < N; i++) {
//			input[i] = sc.nextInt();
//		}
//		isSelected = new boolean[N];
		
//		순열(0);
//		순열();
//		조합(0, 0);
//		중복순열(0);
//		중복조합(0,0);
//		부분집합바이너리카운팅();
//		부분집합재귀(0);
		
//		BFS이진트리탐색(1);
		BFS이진트리레벨별탐색(1);
		}
	
	private static void BFS이진트리레벨별탐색(int index) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(index);
		
		int lvl = 0;		
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.print(lvl++ + " : ");
			for( int i = 0; i < size; i++) {
				int v = q.poll();
				System.out.print(bfsData[v] + " ");
				
				int left = v * 2, right = v * 2 + 1;
				if(left >= bfsData.length) continue;
				q.offer(left);
				
				if(right >= bfsData.length) continue;
				q.offer(right);
			}
			System.out.println();		
		}
	}
	
	private static void BFS이진트리탐색(int index) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(index);
		
		int lvl = 0;
		while(!q.isEmpty()) {
			
			int v = q.remove();
			System.out.println(bfsData[v]);
			
			int left = v * 2, right = v * 2 + 1;
			if(left >= bfsData.length) continue;
			q.offer(left);
			
			if(right >= bfsData.length) continue;
			q.offer(right);
		}
	}

	private static void 순열(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 0; i < N; i ++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			순열(cnt + 1);
			isSelected[i] = false;
		}
	}


	
	private static void 부분집합재귀(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i ++) {
				if(isSelected[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		부분집합재귀(cnt + 1);
		isSelected[cnt] = false;
		부분집합재귀(cnt + 1);

	}
}



/*
public class 복습 {
	static int N, R;
	static int[] input;
	static int[] numbers;
	static boolean[] isSeleted;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N]; //순열, 조합
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
//		순열();
//		중복순열();
//		조합();
//		중복조합();
//		부분집합바이너리카운팅1();
//		부분집합바이너리카운팅2();
//		부분집합재귀(0); //인덱스가 첫번째부터 시작해야해서 인자값이 0
	}

	private static void 순열(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; i++) { //0부터 N개
			if(isSelected[i]) continue;
			numbers[cnt] = input[i]; //여기
			isSelected[i] = true;
			순열(cnt+1);
			isSelected[i] = false;
			
		}
	}


	private static void 조합(int index, int start) {
		if(index == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<N; i++) {
			numbers[index] = input[i];
			조합(index+1, i+1);
		}
	
	}
}
	
/*
	private static void 중복조합(int index, int start) {
		if(index == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<N; i++) {
			numbers[index] = i;
			조합(index+1, i);
		}
	}
	
	private static void 중복순열(int index) {
		if(index == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=N; i++) {
			numbers[index] = i;
			중복순열(index+1);
		}
	}
	
	
	private static void 부분집합바이너리카운팅1() { //★
		for(int i=1; i<Math.pow(2, 5)-1; i++) { //공집합, 진부분집합 제거 (상태값인  i가 0인게 공집합, i가 모두 1인경우가 진부분집합)
			for(int j=0; j<N; j++) {
				if((i & (1<<j)) != 0) { //하나의 상태에서 비교
					System.out.print(input[j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	private static void 부분집합바이너리카운팅2() {
		//부분집합의 경우의 수만큼 반복
		for(int i=0; i< (1<<N); i++) {
//			System.out.println(i + "-" + Integer.toBinaryString(i));
			for(int j=0; j<N; j++) {
				if((i & (1<<j)) != 0) {
					System.out.print(input[j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	private static void 부분집합재귀(int cnt) {
		
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		부분집합재귀(cnt+1);
		isSelected[cnt] = false;
		부분집합재귀(cnt+1);
		
	}
	
}
*/