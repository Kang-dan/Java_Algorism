//통과 
package 스터디;

import java.util.*;
import java.io.*;

public class PG_카카오_L2_양궁대회 {

	public static void main(String[] args) throws IOException {	
	}
	
	/*
	비기거나 라이언이 지는 경우 -1 리턴
	모든 과녁점수에 대해 각 선수의 최종점수 계산 -> 가장 높은 선수가 우승, 같을 경우 어피치 우승
	라이언이 어피치와 가장 큰 점수차로 이기기 위한 n발 화살을 어떤 과녁점수에 맞혀야 하는가!
	방법이 여러가지일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 리턴하기
	        
	순서 상관없고, 중복가능한 조합 10Cn
	조합으로 뽑은 배열의 원소값을 비교해서 선택하기
	*/
	class Solution {
	    
	    static int max; //점수차이
	    static int[] answer; //최종 결과 배열
	    static int[] lion, input; //조합 선택 배열 
	    
	    public int[] solution(int n, int[] info) {//화살의 개수, 어피치가 맞힌 과녁 점수개수(10점부터 0점)
	        // int[] answer = {};
	        //info배열 : 10점부터 0점까지 역순으로 되어있음 
	        answer = new int[11];
	        lion = new int[11];
	        input = new int[11];
	        max = -1;
	        
	        for(int i = 0; i <= 10; i++) lion[i] = -1;
	        combination(n, info, 0, 0); //화살개수, 선택한 개수, 조합시작인덱스(1점부터)
	        
	        //만역 answer배열이 갱신된게 없으면 -1리턴
	        if(max == -1) {
	            int[] fail = {-1};
	            return fail;
	        }
	        return answer;
	    }
	    
	    static public void combination(int select, int[] info, int cnt, int start) {
	        if(cnt == select) {
	            int[] lion2 = new int[11];
	            //라이언 배열에 담기
	            for(int i = 0; i <= 10; i++){
	                if(lion[i] != -1) lion2[10-lion[i]]++;
	            }
	            
	            int sumA = 0, sumL = 0; //어피치합, 라이언합
	            //라이언과 어피치의 점수 계산하기 (info배열 역순이랑 비교하기)
	            for(int i = 0; i <= 10; i++){
	                if(info[i] < lion2[i]) sumL += 10-i; //배열의 값이 라이언이 더 큰 경우 라이언 승
	                else if(info[i] >= lion2[i] && info[i] != 0) sumA += 10-i; //아닌경우 어피치 승
	            }
	            //만약 라이언이 점수가 더 높고, 점수차가 이전보다 더 크다면 배열 갱신해주기
	            if(sumL > sumA && max < sumL - sumA) {
	                max = sumL - sumA;
	                
	                for(int i = 10; i >= 0; i--) {
	                    if(lion2[i] != -1) answer[i] = lion2[i]; //배열 복사
	                }
	            }
	            
	            return;
	        }
	        
	        for(int i = start; i <= 10; i++){
	            lion[cnt] = i;
	            combination(select, info, cnt + 1, i); //중복선택 조합
	        }
	    }
	}

}
