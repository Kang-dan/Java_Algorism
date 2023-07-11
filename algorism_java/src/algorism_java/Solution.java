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