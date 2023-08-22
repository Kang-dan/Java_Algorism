/*
 * 무게추 개수만큼 순열로 뽑은다음 -> 부분집합 재귀로 처리 (왼쪽 무게 < 오른쪽 무게)일 경우 가지치기 
 */

package algorism_java;

import java.util.*;
import java.io.*;

public class swea_3234_준환이의양팔저울_순열과부분집합 {

	static int gramCnt, gramSum; //무게추 개수, 무게추 총합  
	static int[] gram;
	static int resultCnt, doubleMul; //최종경우의 수 
	
	static int[] select; //순열에서 뽑은 값 
	static boolean[] isSelected; //중복확인 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= tCnt; test++) {
			resultCnt = 0; //초기화
			
			gramCnt = Integer.parseInt(br.readLine()); //무게추 개수 입력 
			
			gram = new int[gramCnt];
			select = new int[gramCnt];
			isSelected = new boolean[gramCnt];
			
			st = new StringTokenizer(br.readLine());
			
			//무게 추 배열 입력 받기
			for(int i = 0; i < gramCnt; i++) {
				gram[i] = Integer.parseInt(st.nextToken());
				gramSum += gram[i]; //저울의 총 합 
			}
			
			//순열 -> 부분집합에서 가지치기 
			perm(0);
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}

		bw.close();
		br.close();
	}
	
	private static void perm(int cnt) {
		
		if(cnt == gramCnt) {
			부분집합(0, 0, 0);
		}
		
		for(int i = 0; i < gramCnt; i++) {
			if(isSelected[i]) continue;
			select[cnt] = gram[i];
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	private static void 부분집합(int cnt, int left, int right) {
		if(left < right) return; //가지치기 (왼쪽보다 오른쪽이 더 무거울 때)
		
		if(cnt == gramCnt) {
			resultCnt++; //경우의 수 추가 
			return;
		}
		
		부분집합(cnt + 1, left + select[cnt], right); //왼쪽에 올리기 
		부분집합(cnt + 1, left, right + select[cnt]); //오른쪽에 올리
	}

}
