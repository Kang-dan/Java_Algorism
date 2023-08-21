package baekjoon;

import java.util.*;
import java.io.*;

public class 강대은_BJ_16918_봄버맨 {

    static int r, c;
    static char[][] map;
    static char[][] mapCopy3; //3초전 맵 복사
    static char[][] mapCopy2; //모든칸 폭탄 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());  c
        c = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        map = new char[r+2][c+2];
        for(int i = 1; i <= r; i++) {
            String s = br.readLine();
            for(int j = 1; j <= c; j++) {
                map[i][j] = s.charAt(j-1); //초기 맵 
            }
        }

        //모든칸이 폭탄일 때에는 이걸 출력 
        mapCopy2 = new char[r+2][c+2];
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                mapCopy2[i][j] = 'O';
            }
        }

        mapCopy3 = new char[r+2][c+2];

        for(int i = 1; i <= time; i++) {
            //1초를 그대로
        	if(i == 1) {
//        		mapCopy3 = Arrays.copyOf(map, map.length);
        		for(int j = 0; j < map.length; j++)
        			System.arraycopy(map[j], 0, mapCopy3[j], 0, mapCopy3[j].length);
        		continue;
        	}
        	if(i % 2 == 0) {
        		모든칸폭탄(); //모두 0
        		continue;
        	}
        	
        	if(i % 2 == 1)  {
        		폭발후상태();
        		continue;
        	}
        }

        //출력 
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // mapCopy3에 map복사해두고, map에 모두 0인 맵(mapCopy2)을 복사해넣고, map과 mapCopy3에서 0인 부분 인덱스와 사방을 .으로 만들어주기 
    private static void 폭발후상태() {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
             
        //mapCopy3dptj 0인 부분 인덱스와 사방을 .으로 만들어주기 
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(mapCopy3[i][j] == 'O') {
                	map[i][j] = '.';
                	for(int d = 0; d < 4; d++) {
                		map[i + dy[d]][j + dx[d]] = '.';
                	}
                }
            }
        }
       
//      mapCopy3 = Arrays.copyOf(map, map.length);
        for(int j = 0; j < map.length; j++)
			System.arraycopy(map[j], 0, mapCopy3[j], 0, mapCopy3[j].length);
    }

	private static void 모든칸폭탄() {
		for(int i = 0; i < mapCopy2.length; i++)
			System.arraycopy(mapCopy2[i], 0, map[i], 0, map[i].length);
	}
	
}