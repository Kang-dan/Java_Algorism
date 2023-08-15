import java.util.Scanner;

public class BOJ_S4_2839_설탕배달_재귀 {
	static int goal;
	static int ans = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		goal = sc.nextInt();
		solve(0, 0);
		System.out.println(ans);
	}
	static void solve(int weight, int cnt) {
		if (ans != -1) return;
		if (weight > goal) return;
		if (weight == goal) {
			ans = cnt;
			return;
		}
		
		solve(weight + 5, cnt + 1);
		solve(weight + 3, cnt + 1);
	}
}