import java.util.Scanner;

public class BOJ_S4_2839_설탕배달_그리디 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 4 || N == 7) {
			System.out.println(-1);
			return;
		}
		int ans = N / 5;
		if (N % 5 == 1 || N % 5 == 3) {
			ans++;
		} else if (N % 5 == 2 || N % 5 == 4) {
			ans += 2;
		}
		System.out.println(ans);
	}
}