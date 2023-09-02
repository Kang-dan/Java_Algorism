/* DP (작은 문제 -> 큰 문의 해를 구하는 방식) 
       0   1   2   3   4   5   6   7   8   9   10
    --------------------------------------------
1   |  1   1   1   1   1   1   1   1   1   1   1
2   |  1   1   2   2   3   3   4   4   5   5   6
5   |  1   1   2   2   3   4   5   6   7   8   10

3 10
1
2
5
 */
package 스터디;

import java.util.*;
import java.io.*;

public class BJ_G5_2293_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k + 1]; //경우의 수 누적이 담겨있는 배열 
		int[] coin = new int[n + 1]; //동전 n개의 가치 
		
		for(int i = 0; i < n; i++) coin[i] = Integer.parseInt(br.readLine());
		
		dp[0] = 1; //0원을 만드는 방법은 하나뿐 
		for(int i = 0; i < n; i++) { // 동전 개수만큼 
			for(int j = coin[i]; j <= k; j++) { // 합이 k가 되기까지 경우의 수 누적 
				dp[j] += dp[j - coin[i]]; //j원을 만들 수 있는 경우의 수 업데이트 (coin[i]를 사용하거나 사용하지 않는 두 가지 경우)
			}
		}
		
		bw.write(dp[k]+""); //k원을 만드는 경우의 수 출력 
		
		bw.flush();
		bw.close();
		br.close();
	}
}
