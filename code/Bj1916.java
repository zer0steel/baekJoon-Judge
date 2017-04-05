

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class Bj1916 {
	private static int numOfVertex;
	private static int numOfEdge;
	private static Map<Integer, List<Point>> G;
	private static int startV;
	private static int endV;
	private static int[] dist;
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
	}

	private static void dijkstra() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		dist = new int[numOfVertex + 1];
		Arrays.fill(dist, INF);
		dist[startV] = 0;
		q.offer(new Point(startV, 0));
		while(!q.isEmpty()) {
			Point here = q.poll();
			List<Point> adj = G.get(here.vertex);
			if(adj != null)
				for(Point dest : adj) {
					int distence = dist[here.vertex] + dest.weight;
					if(dist[dest.vertex] >= distence) {
						dist[dest.vertex] = distence;
						q.offer(new Point(dest.vertex, dist[dest.vertex]));
					}
				}
		}
		System.out.println(dist[endV]);
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		numOfVertex = parseInt(in.readLine().trim());
		numOfEdge = parseInt(in.readLine().trim());
		G = new HashMap<>();
		for(int i = 1; i <= numOfEdge; i++) {
			String[] temp = in.readLine().split(" ");
			List<Point> adj = G.get(parseInt(temp[0]));
			if(adj == null) {
				adj = new ArrayList<>();
				G.put(parseInt(temp[0]), adj);
			}
			adj.add(new Point(parseInt(temp[1]), parseInt(temp[2])));
		}
		String[] temp = in.readLine().split(" ");
		startV = parseInt(temp[0]);
		endV = parseInt(temp[1]);
	}
}

class Point implements Comparable<Point>{
	int vertex;
	int weight;
	public Point(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	@Override
	public int compareTo(Point o) {
		return (this.weight < o.weight) ? -1 : 1;
	}
}