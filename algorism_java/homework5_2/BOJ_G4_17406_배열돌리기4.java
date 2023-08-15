import java.util.Scanner;

public class BOJ_G4_17406_배열돌리기4 {
	static int N, M, K, rotateMin, ans = (int)1e9;  // 행, 열, 회전횟수, 순열의최솟값, 전체순열최솟값
	static int[][] map, mapClone; // 초기, 복사
	static int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };	// 사방으로 움직이면서 회전시 사용
	static int[][] arr, tempArr; // 회전정보 : 초기 위치(행, 열, 크기)

	public static void main(String[] args) {	// 메인메서드
		Scanner sc = new Scanner(System.in);	// 입력받기
		N = sc.nextInt();	// 행입력
		M = sc.nextInt();	// 열입력
		K = sc.nextInt();	// 회전횟수
		map = new int[N + 1][M + 1];		// 데이터 담을맵
		mapClone = new int[N + 1][M + 1];	// 회전시 담을 임시 맵
		arr = new int[K][];  // 회전정보 담을 배열
		tempArr = new int[K][];	// 순열의 결과 회전정보 담을 배열
		for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) map[i][j] = sc.nextInt();

		for (int i = 0; i < K; i++) arr[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() }; // r, c, s

		perm(0, 0);  // 순열 구하기
		System.out.println(ans);
		sc.close();
	}

	// 순열 구하고 순열이 다 구해지면 회전 호출
	private static void perm(int len, int flag) {
		if (len == K) {
			// 회전하기전 맵 복사하기
			for (int i = 1; i <= N; i++) mapClone[i] = map[i].clone();

			// 순열이 준비되었다면 해당 순열의 회전 연산 처리하기
			solve();
			ans = Math.min(ans, rotateMin);  // 이전 순열의 결과와 이번 순열의 결과의 최솟값을 저장
			return;
		}
		for (int i = 0; i < arr.length; i++) {	// 순열 구하기
			if ((flag & 1 << i) != 0) continue;
			tempArr[len] = arr[i];
			perm(len + 1, flag | 1 << i);
		}
	}

	private static void solve() {
		rotateMin = Integer.MAX_VALUE;	// 최솟값 초기화
		for (int i = 0; i < K; i++) {	// 회전시키기
			rotate(tempArr[i][0], tempArr[i][1], tempArr[i][2]);
		}

		// 배열을 다 돌린 후의 각 행의 최소값 찾기
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum += mapClone[i][j];
			}
			rotateMin = Math.min(sum, rotateMin);	// 각행의 최솟값 중에서 가장 작은값을 저장
			sum = 0;
		}
	}

	// 회전 처리하기
	static void rotate(int x, int y, int cnt) {	// 회전하기
		for (int i = 1; i <= cnt; i++) {
			int nx = x - i;
			int ny = y - i;
			int temp = mapClone[nx][ny];	// 저장할 값을 미리 변수에 담기
			for (int d = 0; d < 4; d++) {
				for (int j = 0; j < 2 * i; j++) {
					nx += dx[d];
					ny += dy[d];
					int val = mapClone[nx][ny];
					mapClone[nx][ny] = temp;
					temp = val;
				}
			}
		}
	}
}

/**
입력
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1

출력
12
 */