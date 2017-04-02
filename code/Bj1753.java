

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
		// �迭�� 1������ ���� ���Ͽ� ��ĭ �� �÷��� �����Ѵ�.
		G = new ArrayList[numOfEdge + 1];
		for(int i = 1; i <= numOfEdge; i++) {
			String[] e = in.readLine().split(" ");
			int startV = parseInt(e[0]);
			if(G[startV] == null)
			     G[startV] = new ArrayList<>();
			// ���� �������� �迭�� ���������� �����Ѵ�.
			// e[1] = ���Բ����� | e[2] = ����ġ
			G[startV].add(new Case(parseInt(e[1]), parseInt(e[2])));
		}
	}
	
	static void dijkstra2() {
		d = new int[numOfVertex + 1];
		// ���������� �����ϰ� ��� �Ÿ��� ���Ѵ�� �ʱ�ȯ��
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
		// �켱����ť�� �迭�� ���� �����Ͱ� �ִٸ� �ݺ��Ѵ�.
		while( !q.isEmpty() ) {
			Case here = q.poll();
			ArrayList<Case> g = G[here.vertex];
			if(g != null)
				for(int i = 0; i < g.size(); i++) {
					Case dest = g.get(i);
					/* 
					 * G[here.vertex] �� ����Ʈ�� �����µ� �� ����Ʈ�� here.vertex �������� ����� ������ �ִ� ���������� ����̴�.
					 * here.vertex == ���� | dest.vertex == ���� | dest.distance == ����ġ
					 * d[dest.vertex] �� �ǹ̴� ������ ������������ �Ÿ��� ��Ÿ����
					 * d[here.vertex](���� �ִ� ������������ �Ÿ�) + dest.distance(���� �ִ°��� ������������ ����ġ)
					 * �� ���Ͽ� d[dest.vertex] �� ũ�ٸ� �� ����� �Ÿ��� ã������ �ȴ�.
					 */
					if(d[dest.vertex] >= d[here.vertex] + dest.distance) {
						/*
						 * d[dest.vertex]�� �����ִ� �������� ��ġ���� �Ÿ� + ������������ ����ġ�� ���� ���� �Ҵ��Ѵ�.
						 * �� �� ������ �������� ������ ������������ �Ÿ��� �켱����ť�� �ִ´�.
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