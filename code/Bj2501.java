import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * https://www.acmicpc.net/problem/2501
 * @author Jang
 * 2017. 4. 4.
 */
public class Bj2501 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = in.readLine().split(" ");
		int N = parseInt(numbers[0]);
		int K = parseInt(numbers[1]);
		for(int i = 1, j = 0, k = 0; i <= N; i++) {
			if(N % i == 0) {
				k = i;
				j++;
			}
			if(j == K) {
				System.out.println(k);
				return;
			}
		}
		System.out.println(0);
	}

}