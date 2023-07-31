/* [S/W 문제해결 기본] 1일차 - 최빈수 구하기
어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
다음과 같은 수 분포가 있으면,
10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
최빈수는 8이 된다.
최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

[제약 사항]
학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값이다.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄부터는 점수가 주어진다.

[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
 */

package algorism_java;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) throws Exception {
		int[][] num = new int[5][5];
		int a = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				num[i][j] = a++;
				System.out.printf("%d ", num[i][j]);
			}
			System.out.println();
			a = 1;
		}
		
		/* 역순으로 알파벳 출력하기 
		char[][] a = new char[5][5];
		char c= 'C';
		char c1 = c;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				a[i][j] = c++;
				System.out.printf("%c ", a[i][j]);
			}
			System.out.println();
			c = ++c1;
		}
		*/
		
		
		/* 피라미드 별 만들기 
		Scanner sc = new Scanner(System.in);
		int num = 10;
		for(int i=0; i<10; i++) {
			for(int j=0; j<num-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
	}
}

/*다른 풀이
import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            st = new StringTokenizer(br.readLine());
            int maximum = 0;
            int answer = 0;
            for(int i=0; i<1000; i++){
                int n = Integer.parseInt(st.nextToken());
                arr[n]++;
                if(arr[n]>maximum || (arr[n]==maximum && n>answer)){
                    maximum = arr[n];
                    answer = n;
                }
            }
            System.out.println("#"+num+" "+answer);
        }
    }
}
*/