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
		 * �����ָ� ���� 3�� ���� �� ���ٴ� ���� ����ϸ� ������ ���� ����� ���� ���´�.
		 * 1. �ȸ��ô� ���		| dp[i - 1]
		 * 2. �ٷ� ���� ���� ���ð� ���� �͵� ���ô� ���		dp[i - 3] + wines[i - 1] + wines[i]
		 * 3. �ٷ� ���� ���� �ȸ��ð� ���� ���� ���ô� ��� 	dp[i - 2] + wines[i]
		 * ���� ū ���� dp[i]�� �Ҵ��Ѵ�.
		 */
		for(int i = 3; i <= n; i++) 
			dp[i] = max(dp[i - 1], max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i]);
		System.out.println(dp[n]);
	}
	
	/**
	 * ó���� ���� �˰������� �ȸ��ô°��� ������� ���ߴ�.
	 * �׷��� ���� 2�� �ȸ��ô� ���� �ѹ� �ȸ��ô� ��� �߿��� �� ū ����
	 * ���� ���� �������� �ٷ� �������� ���̴��� �ȸ��̴��ĸ� �������� ���� ���ߴ�.
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
