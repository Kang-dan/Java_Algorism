package algorism_java;

import java.util.*;
import java.io.*;

public class softeer_8_11일 {

	static int carCnt, mid, midCnt; //자동차수, 중앙값, 테스트 중앙값 수
	static int count = 0; //주어진 중앙값과 일치하는 경우의 수 
	static int[] carPrice; //자동차 연비 
	static int[] select; //3개 선택 
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		carCnt = Integer.parseInt(st.nextToken());
		midCnt = Integer.parseInt(st.nextToken());
		
		carPrice = new int[carCnt];
		select = new int[3];
		isSelected = new boolean[carCnt];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < carCnt; i++) {
			carPrice[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(carPrice);
		
		for(int i = 0; i < midCnt; i++) {
			count = 0;
			mid = Integer.parseInt(br.readLine()); // 이 중앙값이랑 차 3개를 선택해 나오는 중앙값과 일치하는 경우의 수를 구해야해요!
			if(mid < carPrice[0] || mid > carPrice[carCnt-1]) {
				bw.write("0"+"\n");
				continue;
			}
			조합(0,0);
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static void 조합(int cnt, int start) {
		if(cnt == 3) {
//			Arrays.sort(select); //위에서 이미 Arrays.sort(carPrice);로 정렬해서 필요없음 
			if(select[1]==mid) count++;
			return;
		}
		for(int i = start; i < carCnt; i++) {
			if(isSelected[i]) continue;
			select[cnt] = carPrice[i];
			isSelected[i] = true;
			조합(cnt + 1, i + 1);
			isSelected[i] = false;
		}
		
	}

}
