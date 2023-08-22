package baekjoon;

import java.util.*;
import java.io.*;

public class 강대은_BJ_1759_암호만들기 {

	static int aeiouCnt; //모음 최소 1개 
	static int nonaeiouCnt; //자음 최소 2개
	static int pwCnt, alCnt; //암호길이, 주어지는 알파벳 개수 
	static char[] inputAlpha; //주어지는 알파벳 담은 배열 
	static char[] select; //선택된 암호 
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
	    StringTokenizer st;
	
	    st = new StringTokenizer(br.readLine());
	    pwCnt = Integer.parseInt(st.nextToken()); //암호길이 
	    alCnt = Integer.parseInt(st.nextToken()); //주어진 문자 수 
	    
	    inputAlpha = new char[alCnt];
	    select = new char[pwCnt];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < alCnt; i++) {
	        inputAlpha[i] = st.nextToken().charAt(0);
	    }
	    
	    //오름차순 정렬 
	    Arrays.sort(inputAlpha);
	    
	    //조합 (pwCnt만큼 선택)
	    combination(0, 0);
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
	
	private static void combination(int cnt, int start) throws IOException {
		if(cnt == pwCnt) {
			aeiouCnt = 0; nonaeiouCnt = 0;
			//모음 최소 1개, 자음 최소 2개여야 함
			for(int i = 0; i < cnt; i++) {
				if(select[i] == 'a' || select[i] == 'e' || select[i] == 'i' || select[i] == 'o' || select[i] == 'u') {
					aeiouCnt++;
				} else nonaeiouCnt++;
			}
			if(aeiouCnt < 1 || nonaeiouCnt < 2) return;
			
			for(char v : select) bw.write(v);
			bw.write("\n");
			
			return;
		}
		
		for(int i = start; i < alCnt; i++) {
			select[cnt] = inputAlpha[i];
			combination(cnt + 1, i + 1);
		}
	}
	
}