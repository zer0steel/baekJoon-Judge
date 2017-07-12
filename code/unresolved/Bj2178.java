package unresolved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Bj2178 {
	private static int N, M, min = Integer.MAX_VALUE;
	private static int[][] maze;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		N = parseInt(temp[0]);
		M = parseInt(temp[1]);
		maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			maze[i] = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		DFS(0,0,1);
		System.out.println(min);
	}

	private static void DFS(int x, int y, int deep) throws InterruptedException {
		if(x == N - 1 && y == M - 1) {
			min = (deep < min) ? deep : min;
			return;
		}
		maze[x][y] = 0;
		
		if(y > 0 && maze[x][y - 1] == 1) 
			DFS(x,y - 1, deep + 1);
		
		if(y < M - 1 && maze[x][y + 1] == 1) 
			DFS(x,y + 1, deep + 1);
		
		if(x > 0 && maze[x - 1][y] == 1) 
			DFS(x - 1,y, deep + 1);
		
		if(x < N - 1 && maze[x + 1][y] == 1) 
			DFS(x + 1,y, deep + 1);
		
		maze[x][y] = 1;
	}


	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
