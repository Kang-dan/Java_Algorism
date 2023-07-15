/* 1859. 백만 장자 프로젝트 (오래걸림 + 메모리 크기 조절 중요)
25년 간의 수행 끝에 원재는 미래를 보는 능력을 갖게 되었다. 이 능력으로 원재는 사재기를 하려고 한다.
다만 당국의 감시가 심해 한 번에 많은 양을 사재기 할 수 없다.
다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.

    1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
    2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
    3. 판매는 얼마든지 할 수 있다.

예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스 별로 첫 줄에는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고,
둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다.
각 날의 매매가는 10,000이하이다.

[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.
 */

package algorism_java;

import java.util.*;
import java.io.*;

public class java_SWEA_1859 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			long[] num = new long[N];
			for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
			}
			
			long max, sum=0, result=0;
			int max_index=0, pre_index=0;
			while(max_index < N-1) {				
				pre_index = max_index;
				if(pre_index==0) max = num[0];
				else max = 0;
				for(int i=pre_index+1; i<N; i++) {
					if(max <= num[i]) {
						max = num[i];
						max_index = i;		
					}
				}
				//매매가 계산
				if(max_index==0) max_index++;
				else if(pre_index==0) {
					for(int i=0; i<max_index; i++) {
						sum+=num[i];
					}
					result = max_index*max - sum;
				}
				else {
					sum=0;
					for(int i=pre_index+1; i<max_index; i++) {
						sum+=num[i];
					}
					if(sum!=0) result = result + (max_index-pre_index-1)*max - sum;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}

}

/* 다른 풀이
 import java.util.Scanner;
 
public class Solution {
    Scanner sc = new Scanner(System.in);
    int T, N;
    long answer;
    int trade[] = new int[1000001];
    public Solution(){
        T=sc.nextInt();
        for(int testCase =1; testCase <= T; testCase++) {
            N=sc.nextInt();
            for(int i = 0; i < N; i++) {
                trade[i]=sc.nextInt();
            }
            answer = init();
            print(testCase, answer);
        }
    }
    public static void main(String[] args) {
        new Solution();
    }
    long init() {
        long sum=0,max=0;
        for(int i = N-1; i>=0;i--) {
            if(max<trade[i]) {
                max=trade[i];
                continue;
            }
            if(max>trade[i]) {
                sum+=(max-trade[i]);
            }
        }
        return sum;
    }
    void print(int caseNum, long answer) {
        System.out.println("#" + caseNum+" "+ answer);
    }
}
 */