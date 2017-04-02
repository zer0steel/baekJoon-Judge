

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

/**
 * https://www.acmicpc.net/problem/1753
 * @author Jang
 */
public class Bj1753 {
	
	private static final int INF = 100000000;
	private static int numOfVertex, numOfEdge, startV;
	private static int[] d;
	private static ArrayList<Case>[] G;
	
	public static void main(String[] args) throws IOException {
		dataInput();
		dijkstra2();
		printResutl();
	}
	static void dataInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		numOfVertex = parseInt(temp[0]);
		numOfEdge = parseInt(temp[1]);
		startV = parseInt(in.readLine());
		// 배열을 1번부터 쓰기 위하여 한칸 더 늘려서 생성한다.
		G = new ArrayList[numOfEdge + 1];
		for(int i = 1; i <= numOfEdge; i++) {
			String[] e = in.readLine().split(" ");
			int startV = parseInt(e[0]);
			if(G[startV] == null)
			     G[startV] = new ArrayList<>();
			// 진출 꼭지점의 배열에 간선정보를 저장한다.
			// e[1] = 진입꼭지점 | e[2] = 가중치
			G[startV].add(new Case(parseInt(e[1]), parseInt(e[2])));
		}
	}
	
	static void dijkstra2() {
		d = new int[numOfVertex + 1];
		// 시작지점을 제외하고 모든 거리를 무한대로 초기환다
		Arrays.fill(d, INF);
		d[startV] = 0;
		
		PriorityQueue<Case> q = new PriorityQueue<>(new Comparator<Case>() {
			
			@Override
			public int compare(Case o1, Case o2) {
				// TODO Auto-generated method stub
				return o1.distance < o2.distance ? -1 : 1;
			}
		});
		
		q.offer(new Case(startV, d[startV]));
		// 우선순위큐의 배열에 남은 데이터가 있다면 반복한다.
		while( !q.isEmpty() ) {
			Case here = q.poll();
			ArrayList<Case> g = G[here.vertex];
			if(g != null)
				for(int i = 0; i < g.size(); i++) {
					Case dest = g.get(i);
					/* 
					 * G[here.vertex] 는 리스트가 나오는데 이 리스트는 here.vertex 꼭지점을 진출로 가지고 있는 꼭지점들의 목록이다.
					 * here.vertex == 진출 | dest.vertex == 진입 | dest.distance == 가중치
					 * d[dest.vertex] 의 의미는 목적지 꼭지점까지의 거리를 나타내며
					 * d[here.vertex](지금 있는 꼭지점까지의 거리) + dest.distance(지금 있는곳과 목적지까지의 가중치)
					 * 와 비교하여 d[dest.vertex] 가 크다면 더 가까운 거리를 찾은것이 된다.
					 */
					if(d[dest.vertex] >= d[here.vertex] + dest.distance) {
						/*
						 * d[dest.vertex]에 지금있는 꼭지점의 위치까지 거리 + 목적지까지의 가중치를 더한 값을 할당한다.
						 * 그 후 목적지 꼭지점과 목적지 꼭지점까지의 거리를 우선순위큐에 넣는다.
						 */
						d[dest.vertex] = min(d[dest.vertex], d[here.vertex] + dest.distance);
						q.offer(new Case(dest.vertex, d[dest.vertex]));
					}
				}
		}
	}
	
	static void printResutl() {
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= numOfVertex; i++) {
			if(d[i] == INF) 
				sb.append("INF");
			else
				sb.append(d[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int min(int num1, int num2) {
		return num1 < num2 ? num1 : num2;
	}
	
	static class Case {
		int vertex;
		int distance;
		Case(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
}