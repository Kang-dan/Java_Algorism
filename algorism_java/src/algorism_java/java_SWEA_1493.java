/* 1493. 수의 새로운 연산
2차원 평면 제 1사분면 위의 격자점 (x,y)에 위 그림과 같이 대각선 순서로 점에 수를 붙인다.
점 (x,y)에 할당된 수는 #(x,y)로 나타낸다.

예를 들어 #(1,1) = 1, #(2,1)=3, #(2,2) = 5, #(4,4) = 25이다.
반대로 수 p가 할당된 점을 &(p)로 나타낸다.

예를 들어 &(1) = (1,1), &(3) = (2,1), &(5) = (2,2), &(25) = (4,4)이다.
두 점에 대해서 덧셈을 정의한다. 점 (x,y)와 점 (z,w)를 더하면 점 (x+z, y+w)가 된다.
즉, (x,y) + (z,w) = (x+z, y+w)로 정의한다.

우리가 해야 할 일은 수와 수에 대한 새로운 연산 ★를 구현하는 것으로, p★q는 #(&(p)+&(q))으로 나타난다.
예를 들어, &(1)=(1,1), &(5) = (2,2)이므로, 1★5 = #(&(1)+&(5)) = #((1,1)+(2,2)) = #(3,3) = 13이 된다.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 두 정수 p,q(1 ≤ p, q ≤ 10,000)가 주어진다.

[출력]
각 테스트 케이스마다 ‘#t’(t는 테스트 케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 각 테스트 케이스마다 p★q의 값을 출력한다.
 */

package algorism_java;

import java.util.Scanner;
import java.io.FileInputStream;

public class java_SWEA_1493 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int[][] num = new int[1000][1000];
			
			//배열에 숫자 넣기
			int i=1, count=1, a, b;
			int p_a=1, p_b=1, q_a = 1, q_b=1; //p와 q의 인덱스값 찾
			while(i<=100000) {
				a=1; b=count;
				for(int j=1; j<=count; j++) {
					num[a][b] = i;
					if(p==i) {
						p_a = a;
						p_b = b;
					}
					if(q==i) {
						q_a = a;
						q_b = b;
					}
					a++; b--; i++;
					if(i>100000) break;
				}
				count++;
			}
			
			System.out.println("#"+test_case+" " +num[p_a+q_a][p_b+q_b]);
			
		}
	}

}

/* 다른 풀이
import java.io.*;
import java.util.*;
 
public class Solution {
    static int[] s = new int[300];
     
    public static void main(String[] args) throws Exception{
        s[1] = 1; 
        for(int i=2;i<s.length;i++) {
            s[i] = s[i-1] + i-1;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        int p,q;
         
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());           
            int r, c;
             
            r = getR(p);
            c = p - s[r] + 1;
            r -= (p-s[r]);
             
            int rSum = r;
            int cSum = c;
             
            r = getR(q);//첫 행의 열 값
            c = q - s[r] + 1;
            r -= (q-s[r]);
             
            rSum += r;
            cSum += c;
             
            int val = s[rSum + cSum -1] + cSum - 1;
             
            sb.append("#").append(tc).append(" ").append(val).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
 
    // val 숫자에 해당하는 좌표(r,c)를 구하기 위해 s 배열에 몇 번째 index 라인인지 리턴
    static int getR(int val) {
        int result = 0;
        for (int i = 1; i < s.length; i++) {
            if(s[i] > val) {
                result = i-1;
                break;
            }
        }
        return result;
    }
}
*/