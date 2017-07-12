package unresolved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

public class Bj2294 {
	
	private static int numOfCoins;
	private static int sumOfCoins;
	private static int[] coins;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		numOfCoins = parseInt(temp[0]);
		sumOfCoins = parseInt(temp[1]);
		coins = new int[numOfCoins + 1];
		for(int i = 1; i <= numOfCoins; i++) {
			coins[i] = parseInt(in.readLine().trim());
		}
	}
}