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
		 * ���� 4�� ���ε�� 4�� �� �� �ִ� ���� 
		 * f(n) = n�� ���ڰ� �� �� �ִ� ����� ��.
		 * 1 + f(3) , 2 + f(2), 3 + f(1) 3������ �ִ�.
		 * ���ڵ��� ������ 3���� ��� ���δ� �Ȱ����� 
		 * ������ ������ �������� ����Ͽ� ��� ����Ǽ� �̱� ������ ���� ���Ѵ�.
		 * ��ȭ�� : f(n) = f(n - 1) + f(n - 2) + f(n - 3); 
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