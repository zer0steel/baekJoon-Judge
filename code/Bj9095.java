import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * https://www.acmicpc.net/problem/9095
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
		 * �닽�옄 4瑜� �삁濡쒕뱾硫� 4媛� �맆 �닔 �엳�뒗 寃쎌슦�뒗 
		 * f(n) = n�쓽 �닽�옄媛� �맆 �닔 �엳�뒗 寃쎌슦�쓽 �닔.
		 * 1 + f(3) , 2 + f(2), 3 + f(1) 3醫낅쪟媛� �엳�떎.
		 * 臾몄젣�뒗 �닽�옄�쓽 �닚�꽌源뚯� 怨좊젮 紐⑤뱺 寃쎌슦�쓽�닔�씠湲� �븣臾몄뿉 �쟾遺� �뜑�븳�떎.
		 * �젏�솕�떇 : f(n) = f(n - 1) + f(n - 2) + f(n - 3); 
		 */
		for(int i = 4; i <= 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];		
		}
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = parseInt(in.readLine().trim());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
