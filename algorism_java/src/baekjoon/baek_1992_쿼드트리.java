package baekjoon;

import java.util.*;
import java.io.*;

public class baek_1992_쿼드트리 {

	static int[][] map; //입력받을 맵 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			String st = br.readLine();
			for(int j = 0; j < size; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		
		int flag = map[0][0]; //시작값 
		int check = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map[i][j] != flag) {
					check = 1;
					break;
				}
			}
			if(check == 1) break;
		}
		
		if(check == 0) bw.write(flag+"");
		else press(0, 0, size);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void press(int y, int x, int N) throws IOException { //시작인덱스, 맵크기 
		bw.write("(");
		
		int newSize = N/2;
		int flag;
		int check;
		
		//왼 위
		flag = map[y][x];
		check = 0;
		for(int i = y; i < y + newSize; i++) {
			for(int j = x; j < x + newSize; j++) if(map[i][j] != flag) check = 1;
		}
		if(check == 0) bw.write(flag+"");
		else press(y, x, newSize);
			
		//오 위
		flag = map[y][x+newSize];
		check = 0;
		for(int i = y; i < y + newSize; i++) {
			for(int j = x + newSize; j < x + N; j++) if(map[i][j] != flag) check = 1;
		}
		if(check == 0) bw.write(flag+"");
		else press(y,x+newSize,newSize);
		
		//왼 아
		flag = map[y+newSize][x];
		check = 0;
		for(int i = y+newSize; i < y + N; i++) {
			for(int j = x; j < x + newSize; j++) if(map[i][j] != flag) check = 1;
		}
		if(check == 0) bw.write(flag+"");
		else press(y+newSize,x,newSize);
		
		//오 아 
		flag = map[y+newSize][x+newSize];
		check = 0;
		for(int i = y + newSize; i < y + N; i++) {
			for(int j = x + newSize; j < x + N; j++) if(map[i][j] != flag) check = 1;
		}
		if(check == 0) bw.write(flag+"");
		else press(y+newSize,x+newSize,newSize);
			
		bw.write(")");
	}
}

/* press함수를 이렇게 간단히 작성 가능 (지피티)
 private static void press(int y, int x, int N) throws IOException {
    int flag = map[y][x];

    boolean isSame = true;
    for (int i = y; i < y + N && isSame; i++) {
        for (int j = x; j < x + N; j++) {
            if (map[i][j] != flag) {
                isSame = false;
                break;
            }
        }
    }

    if (isSame) {
        bw.write(flag + "");
    } else {
        int newSize = N / 2;
        bw.write("(");

        press(y, x, newSize);
        press(y, x + newSize, newSize);
        press(y + newSize, x, newSize);
        press(y + newSize, x + newSize, newSize);

        bw.write(")");
    }
}
 * 
 */

