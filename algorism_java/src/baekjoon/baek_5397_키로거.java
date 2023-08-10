//		StringTokenizer st = new StringTokenizer(br.readLine());
//		String result = st.nextToken();
/*
 * 	이중연결리스트 구현하려다 라이브러리 없어서 스택 2개로 사용 
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class baek_5397_키로거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); //테스트 수 입력 
		for(int test = 0; test < T; test++) {
			String pw = br.readLine(); //키보드 기록 입력 
			
			Stack<Character> s1 = new Stack<>(); //최종 출력 스택 
			Stack<Character> s2 = new Stack<>();
			
			for(int i = 0; i < pw.length(); i++) {
				switch(pw.charAt(i)) {
					//< s1에 빼고 s2에 넣기 
					case '<': if(!s1.isEmpty()) s2.push(s1.pop());
					break;
		
					//> s2에 빼고 s1에 넣기
					case '>': if(!s2.isEmpty()) s1.push(s2.pop());
					break;
					
					//- s1에 빼기 
					case '-': if(!s1.isEmpty()) s1.pop();
					break;
					
					//문자 s1에 넣기 
					default : s1.push(pw.charAt(i));
					break;
				}
			}
			//s2가 남아있으면 빼고 s1에 넣기 
			while(!s2.isEmpty()) s2.push(s1.pop());
			
			//s1 담긴 순서대로가 비밀번호 
			for(int i = 0; i < s1.size(); i++) {
				bw.write(s1.elementAt(i));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}

}
