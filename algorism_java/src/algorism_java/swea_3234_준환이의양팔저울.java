/*
 * 부분집합바이너리카운팅 + 선택한 경우의 수에서 순서고려  => 안됨
 */
package algorism_java;

import java.util.*;
import java.io.*;

public class swea_3234_준환이의양팔저울 {

	static int gramCnt, gramSum;
	static int[] gram;
	static int resultCnt, doubleMul; //최종경우의 수 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tCnt = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= tCnt; test++) {
			resultCnt = 0; //초기화
			
			gramCnt = Integer.parseInt(br.readLine()); //무게추 개수 입력 
			gram = new int[gramCnt];
			
			st = new StringTokenizer(br.readLine());
			
			//무게 추 배열 입력 받기
			for(int i = 0; i < gramCnt; i++) {
				gram[i] = Integer.parseInt(st.nextToken());
				gramSum += gram[i]; //저울의 총 합 
			}
			
			//2^무게추의수 (경우의 수 구하기 -> 최종 경우의 수 구할 때 곱해주기, 예) 123 321 두개는 각각 의 경우의 수로 치니까(순서고려) )
//			doubleMul = 1;
//			for(int i = 1; i < gramCnt; i++) {
//				doubleMul *= 2;
//			}
			
			부분집합바이너리카운팅();
			
			bw.write(String.format("#%d %d\n", test, resultCnt));
		}

		bw.close();
		br.close();
	}
	
	private static void 부분집합바이너리카운팅() {
		int sumLeft; //왼쪽의 합이 더 크거나 같아야함.
		int leftCnt;
		
		for(int i = 0; i < Math.pow(2, gramCnt); i++) {
			sumLeft = 0;
			leftCnt = 0;
			for(int j = 0; j < gramCnt; j++) {	
				if((i & (1 << j)) != 0) {
					sumLeft += gram[j]; //왼쪽 저울 (추 선택)
					leftCnt++; //왼쪽 추 갯수
				}
			}
			
			//만약 왼쪽합이 더 크거나 같으면 경우의 수 추가 
			if(sumLeft >= gramSum-sumLeft) {
				resultCnt++;
				//왼쪽순서고려한 경우의 수 x 오른쪽순서 고려한 경우의 수 
				int rightCnt = gramCnt - leftCnt;
				if(leftCnt > 1 && rightCnt > 1) {
					int resultL = 1, resultR = 1;
					for(int d = 0; d < leftCnt; d++) {
						resultL *= 2;
					}
					for(int d = 0; d < leftCnt; d++) {
						resultR *= 2;
					}
					resultCnt *= resultL * resultR;
				} else if(leftCnt > 1 && rightCnt <= 1) {
					int resultL = 1;
					for(int d = 0; d < leftCnt; d++) {
						resultL *= 2;
					}
					resultCnt *= resultL;
				} else if(leftCnt <= 1 && rightCnt > 1) {
					int resultR = 1;
					for(int d = 0; d < rightCnt; d++) {
						resultR *= 2;
					}
				}
			}
			
		}
		
		//2^무게추의 갯수 만큼 더 곱해주기 (순서고려) 
//		resultCnt = resultCnt * doubleMul;
	}

}
