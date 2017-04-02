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
		
		//�ﰢ���� ���� �ٴں��� �ݺ��� ����
		for(int i = N; i > 1; i--) {
			int[] row = triangle[i];
			/*
			 * i ��° ���� �迭 0������ �ݺ��Ѵ�.
			 * j �� j + 1 ��° �迭�� ���� ���Ͽ� �� ū���� �ٷ� ���� �ִ� ���� j ���� ���Ѵ�.
			 * ex ) ��(�ε���)
			 * 			7(0)
			 * 		3(0)	8(1)
			 * 	8(0)	1(1)	6(2)
			 * ���� ���� j��° �ε����� ���� ��� j , j + 1 �� �� ū���� ���ϸ� ��������.
			 */
			for(int j = 0; j < row.length - 1; j++) 
				triangle[i - 1][j] += row[j] > row[j + 1] ? row[j] : row[j + 1];
		}
		System.out.println(triangle[1][0]);
	}
}