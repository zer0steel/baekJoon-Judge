import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1475
 * @author Jang
 * 2017. 4. 4.
 */
public class Bj1475 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String roomNumber = in.readLine();
		int[] number = new int[10];
		for(int i = 0; i < roomNumber.length(); i++) {
			int n = (int)roomNumber.charAt(i) - '0';
			if(n == 9)
				n -= 3;
			number[n]++;
		}
		
		int max = number[0], maxIdx = 0;
		for(int i = 1; i < 9; i++) 
			if(number[i] > max) {
				max = number[i];
				maxIdx = i;
			}
		
		if(maxIdx == 6) 
			System.out.println((int)Math.ceil((double)number[6] / 2));
		else
			System.out.println(number[maxIdx]);
	}

}
