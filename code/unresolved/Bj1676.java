package unresolved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

public class Bj1676 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(in.readLine().trim());
		
		long result = f(N);
		System.out.println(result);
	}

	private static long f(long n) {
		return (n == 1) ? 1 : n * f(n - 1);
	}
}
