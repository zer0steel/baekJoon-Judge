
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * https://www.acmicpc.net/problem/2460
 * @author Jang
 * 2017. 4. 5.
 */
public class Bj2460 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numOfPerson = 0;
		int max = 0;
		for(int i = 1; i <= 10; i++) {
			String[] str = in.readLine().split(" ");
			numOfPerson += parseInt(str[1]) - parseInt(str[0]);
			max = (numOfPerson > max) ? numOfPerson : max;
		}
		System.out.println(max);
	}

}
