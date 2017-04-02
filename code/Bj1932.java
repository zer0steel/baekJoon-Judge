import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * https://www.acmicpc.net/problem/1932
 * @author Jang
 * 2017. 4. 2.
 */
public class Bj1932 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(in.readLine().trim());
		int[][] triangle = new int[N + 1][];
		for(int i = 1; i <= N; i++) 
			triangle[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//삼각형의 제일 바닥부터 반복문 시작
		for(int i = N; i > 1; i--) {
			int[] row = triangle[i];
			/*
			 * i 번째 행의 배열 0번부터 반복한다.
			 * j 와 j + 1 번째 배열의 값을 비교하여 더 큰값을 바로 위에 있는 행의 j 번에 더한다.
			 * ex ) 값(인덱스)
			 * 			7(0)
			 * 		3(0)	8(1)
			 * 	8(0)	1(1)	6(2)
			 * 보다 시피 j번째 인덱스에 하위 노드 j , j + 1 중 더 큰값을 더하면 문제없다.
			 */
			for(int j = 0; j < row.length - 1; j++) 
				triangle[i - 1][j] += row[j] > row[j + 1] ? row[j] : row[j + 1];
		}
		System.out.println(triangle[1][0]);
	}
}