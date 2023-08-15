
import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_D4_1861_정사각형방_DFS {

	private static int[][] map;
	private static int N;
	private static int maxRoomNo = 0;
	private static int moveCnt = 0;
	private static int cnt = 0;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			maxRoomNo = 987654321;
			moveCnt = 1;

			N = sc.nextInt();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					solve(i, j);

					if (cnt > moveCnt) {
						moveCnt = cnt;
						maxRoomNo = map[i][j];
					} else if (cnt == moveCnt && map[i][j] < maxRoomNo) {
						maxRoomNo = map[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + maxRoomNo + " " + moveCnt);
		}

		sc.close();
	}

	private static void solve(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[nx][ny] == map[x][y] + 1) {
				cnt++;
				solve(nx, ny);
			}
		}
	}
}