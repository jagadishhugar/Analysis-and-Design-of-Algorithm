package jagadish;

import java.util.Scanner;

public class dijkstra {
	public static void main(String[] args) {
		int cost[][] = new int[10][10], dist[] = new int[10], visited[] = new int[20];
		int i, j;
		Scanner in = new Scanner(System.in);
		System.out.println("**** DIJKSTRA'S ALGORITHM ******");
		System.out.println("Enter the number of nodes: ");
		int n = in.nextInt();
		System.out.println("Enter the cost matrix");
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				cost[i][j] = in.nextInt();
			}
		}
		System.out.println("Enter the source vertex: ");
		int sv = in.nextInt();
		dij(cost, dist, sv, n, visited);
		System.out.println("Total Distance from Source to each Destination is");
		for (i = 1; i <= n; i++) {
			System.out.println("From " + sv + "to " + i + "= " + dist[i]);
		}
		System.out.println("\n********* *************** *********");
	}

	static void dij(int cost[][], int dist[], int v, int n, int s[]) {
		int w, u, k;
		int i;
		for (i = 1; i <= n; i++) {
			s[i] = 0;
			dist[i] = cost[v][i];
		}

		s[v] = 1;
		dist[v] = 0;
		for (i = 2; i <= n; i++) {
			u = min(n, dist, s);
			s[u] = 1;
			for (w = 1; w <= n; w++) {
				if (dist[w] > dist[u] + cost[u][w]) {
					dist[w] = dist[u] + cost[u][w];
				}
			}
		}
	}

	static int min(int n, int dist[], int s[]) {
		int i, p = 0, min = 99;
		for (i = 1; i <= n; i++) {
			if (min > dist[i] && s[i] == 0) {
				min = dist[i];
				p = i;
			}
		}
		return p;
	}
}