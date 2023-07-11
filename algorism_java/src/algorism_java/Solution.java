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

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int Test = sc.nextInt();
			int[] score = new int[1000]; // 0이상 100이하 점수 입력
			
			//1000명의 점수 입력
			for(int i=0; i<1000; i++) {
				//Scanner scan = null;
				score[i] = sc.nextInt();
			}
			
			//각 점수 개수
			int[] flag = new int[101];
			for(int i=0; i<1000; i++) {
				flag[score[i]]++;
			}
			
			//최빈수 찾기
			int max = flag[0];
			int max_score = score[0];
			for(int i=1; i<=100; i++){
				if(max <= flag[i]) {
					max = flag[i];
					max_score = i;
				}
			}
			System.out.printf("#%d %d\n", test_case, max_score);
		}
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