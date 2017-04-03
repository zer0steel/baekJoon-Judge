import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

/**
 * https://www.acmicpc.net/problem/2156
 * @author Jang
 * 2017. 4. 3.
 */
public class Bj2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(in.readLine().trim());
		int[] wines = new int[10001];
		for(int i = 1; i <= n; i++) 
			wines[i] = parseInt(in.readLine().trim());
		
		int[] dp = new int[10001];
		dp[1] = wines[1]; 
		dp[2] = wines[1] + wines[2];
		/*
		 * 포도주를 연속 3번 마실 수 없다는 것을 고려하면 다음과 같은 경우의 수가 나온다.
		 * 1. 안마시는 경우		| dp[i - 1]
		 * 2. 바로 전의 것을 마시고 지금 것도 마시는 경우		dp[i - 3] + wines[i - 1] + wines[i]
		 * 3. 바로 전의 것을 안마시고 지금 것을 마시는 경우 	dp[i - 2] + wines[i]
		 * 가장 큰 값을 dp[i]에 할당한다.
		 */
		for(int i = 3; i <= n; i++) 
			dp[i] = max(dp[i - 1], max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i]);
		System.out.println(dp[n]);
	}
	
	/**
	 * 처음에 만든 알고리즘으로 안마시는것을 고려하지 못했다.
	 * 그래서 연속 2번 안마시는 경우와 한번 안마시는 경우 중에서 더 큰 값을
	 * 지금 마신 포도주의 바로 이전것을 마셨느냐 안마셨느냐를 기준으로 각각 구했다.
	 */
	private static void dp(int n, int[] wines) {
		int[] dp = new int[10001];
		dp[1] = wines[1]; 
		dp[2] = wines[1] + wines[2];
		dp[3] = max(wines[2], wines[1]) + wines[3];
		dp[4] = max(wines[3] + wines[1], dp[2]) + wines[4];
		for(int i = 5; i <= n; i++) {
			int max1 = max(dp[i - 3], dp[i - 4]);
			int max2 = max(dp[i - 2], dp[i - 3]);
			dp[i] = max( max1 + wines[i - 1], max2) + wines[i];
		}
		System.out.println(max(dp[n], dp[n - 1]));
	}
}
