import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_D4_1861_정사각형방 {
	static int[][] map;
	static int[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			check = new int[N * N + 1];
		 	
			// 입력받은 데이터 배열을 돌면서 연속되는 숫자가 있는지 체크한다.
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						
						if (map[i][j] + 1 == map[nx][ny]) {
							check[map[i][j]]++;
							break;
						}
					}
					
				}
			}
			int minVal = 1000, maxMove = 0;
			int move = 1;
			for (int i = N * N; i > 0; i--) {
				if (check[i] == 0) {
					move = 1;
					continue;
				}
				move++;
				
				if (maxMove <= move) {
					maxMove = move;
					minVal = i;
				}
			}
//			System.out.println(Arrays.toString(check));
			sb.append("#" + t + " " + minVal + " " + maxMove + "\n");
//			System.out.println("#" + t + " " + minVal + " " + maxMove);
		}
		System.out.print(sb);
	}
}