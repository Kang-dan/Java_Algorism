//DFS + 2차원배열 정렬 
package 스터디;

import java.util.*;
import java.io.*;

public class PG_DFS_여행경로 {

	class Solution {
		
	    static boolean[] visit;
	    static String[] answer;
	    public String[] solution(String[][] tickets) {
	    		    	
	        answer = new String[tickets.length + 1];
	        visit = new boolean[tickets.length + 1];

	    //2차원 배열 정렬하기 (오름차순)
	    Arrays.sort(tickets, new Comparator<String[]>() {
	        @Override
	        public int compare(String[] o1, String[] o2) {
	            if(o1[0].equals(o2[0])) {
	                return o1[1].compareTo(o2[1]);
	            }
	            else if(!o1[0].equals(o2[0])) {
	                return o1[0].compareTo(o2[0]);
	            }
	            return 0;
	        }
	    });
	    
	    Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
				else if(!o1[0].equals(o2[0])) return o1[0].compareTo(o2[0]);
				return 0;
			}
	    	
	    });

	    for(int i = 0; i < tickets.length; i++) {
	        if(tickets[i][0].equals("ICN")) {
	            visit[i] = true;
	            dfs(0, i, tickets);
	        }
	        
	        if(flag == true) break;
	    }

	        return answer;
	    }

	    static boolean flag;
	    public void dfs(int cnt, int v, String[][] tickets) {
	        if(cnt+1 == tickets.length) {
	            flag = true;
	        }

	        answer[cnt] = tickets[v][0];
	        if(flag == true) answer[cnt+1] = tickets[v][1];

	        for(int i = 0; i < tickets.length; i++) {
	            if(flag == true) return;
	            if(visit[i]) continue;
	            if(!visit[i] && tickets[v][1].equals(tickets[i][0])) {
	                visit[i] = true;
	                dfs(cnt + 1, i, tickets);
	            }
	        }
	        visit[v] = false;
	        return;
	    }
	}
}

/*
Arrays.sort(tickets, new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
        if(o1[0].equals(o2[0])) {
            return o1[1].compareTo(o2[1]);
        }
        else if(!o1[0].equals(o2[0])) {
            return o1[0].compareTo(o2[0]);
        }
        return 0;
        
        /*
        
        - compareTo 메서드가 같으면 0을 return 하기 때문에  따로 처리해 줄 필요 없음
        
        if(o1[0].equals(o2[0])) {
            return o1[1].compareTo(o2[1]);
        }
        else {
            return o1[0].compareTo(o2[0]);
        } 
        
        - 더 간략하게 하려면 중괄호 생략하고 한줄 씩
        
        if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
        else return o1[0].compareTo(o2[0]);
        
          - 람다식으로 한 경우
          
      Arrays.sort(tickets, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[1]);
       
        */
