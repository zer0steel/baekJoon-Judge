import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * <a href="https://www.acmicpc.net/problem/9095">https://www.acmicpc.net/problem/9095</a>
 * @author Jang
 * 2017. 4. 2.
 */
public class Bj9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(in.readLine().trim());
		int dp[] = new int[12];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		/* 
		 * 숫자 4를 예로들면 4가 될 수 있는 경우는 
		 * f(n) = n의 숫자가 될 수 있는 경우의 수.
		 * 1 + f(3) , 2 + f(2), 3 + f(1) 3종류가 있다.
		 * 숫자들의 개수는 3가지 경우 전부다 똑같지만 
		 * 문제는 숫자의 순서까지 고려하여 모든 경우의수 이기 때문에 전부 더한다.
		 * 점화식 : f(n) = f(n - 1) + f(n - 2) + f(n - 3); 
		 */
		for(int i = 4; i <= 11; i++) 
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = parseInt(in.readLine().trim());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb.toString());
	}
}