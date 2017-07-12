
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4999
 * @author Jang
 * 2017. 4. 5.
 */
public class Bj4999 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1 = in.readLine();
		String s2 = in.readLine();
		if(s1.length() >= s2.length())
			System.out.println("go");
		else
			System.out.println("no");
	}

}
