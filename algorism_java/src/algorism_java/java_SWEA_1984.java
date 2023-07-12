/* 1984. 중간 평균값 구하기
 * 10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
(소수점 첫째 자리에서 반올림한 정수를 출력한다.)

[제약 사항]
각 수는 0 이상 10000 이하의 정수이다.

[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.

[출력]
출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */

package algorism_java;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class java_SWEA_1984
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] num = new int[10]; //배열 생성
            //10명점수 입력, 최대, 최소값 
            int min=10001, max=-1;
            int min_index=0, max_index=0;
            for(int i=0; i<10; i++){
                num[i] = sc.nextInt();
                if(min>num[i]){
                    min = num[i];
                    min_index = i;
                }
                if(max<num[i]){
                    max = num[i];
                    max_index = i;
                }
            }
            //최대, 최소수 제외한 평균값 (소수점 반올림)
            double sum=0, mid=0;
            for(int i=0; i<10; i++){
                if(i==min_index) continue;
                if(i==max_index) continue;
                sum += num[i];
            }
            mid = sum / 8;
            System.out.println("#" +test_case + " " + String.format("%.0f", mid));
		}
	}
}