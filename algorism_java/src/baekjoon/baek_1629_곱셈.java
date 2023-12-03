package baekjoon;

import java.util.*;
import java.io.*;

public class baek_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
//		st = new StringTokenizer(br.readLine());
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//		int c = Integer.parseInt(st.nextToken());
		
//		long ab = (long) Math.pow(a, b) % c;
		
		long d =  (long) Math.pow(214748364L, 5L);
		
		System.out.println(d);
	}

}
