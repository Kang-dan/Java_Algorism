package 스터디;

import java.util.*;
import java.io.*;

public class PG_2023카카오_미로탈출명령어 {

	/* dfs */

	class Solution {
	    static boolean flag;
	    
	    static int[] str;
	    static int[] dy = {1, 0, 0, -1}; //d, l, r, u (아, 왼, 오, 위)
	    static int[] dx = {0, -1, 1, 0};
	    static boolean[][] visit;

	    public String solution(int n, int m, int x, int y, int r, int c, int k) {
	        String answer = "";
	        
	        str = new int[k];
	        // visit = new boolean[n+1][m+1];
	        //dfs돌기
	        dfs(0, n, m, x, y, r, c, k); //현재 이동 횟수, 시작인덱스, 도착인덱스, k
	        
	        if(!flag) answer = "impossible";
	        else if(flag) {
	            for(int i = 0; i < k; i++) {
	                //d, l, r, u
	                if(str[i] == 0) answer += "d";
	                else if(str[i] == 1) answer += "l";
	                else if(str[i] == 2) answer += "r";
	                else if(str[i] == 3) answer += "u";
	            }
	        }
	        
	        return answer;
	    }

	    public void dfs(int cnt, int n, int m, int x, int y, int r, int c, int k) { //r, c, 는 이동 
	        
	        if(flag) return;
	        
	        if(cnt == k && r == x && y == c) {
	            flag = true;
	            return;
	            //성공 - 문자열 붙여주기
	        }
	        
	        int h = Math.abs(r-x);
	        int w = Math.abs(c-y);
	     
	        if(h+w > k-cnt) return;
	        if((Math.abs(k-cnt) - (h+w)) % 2 == 1) return; //이거 생각하기 어려웠음
	        
	        if(cnt >= k) {
	            //실패 - impossible리턴하기
	            return;
	        }
	        
	        for(int d = 0; d < 4; d++) {
	            if(flag) return;
	            int a = dy[d] + x;
	            int b = dx[d] + y;
	            //배열 범위 확인하기
	            if(a < 1 || a > n || b < 1 || b > m) continue;
	            
	            str[cnt] = d;
	            dfs(cnt + 1, n, m, a, b,r,c, k);
	            if(flag) return;
	        }
	    }
	    
	}

}
