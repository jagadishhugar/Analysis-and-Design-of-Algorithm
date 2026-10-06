package jagadish;

import java.util.Scanner;

public class warshall {
void wshall(int[][] a,int n) 
{ 
int i,j,k; 
for(k=1;k<=n;k++) 
	for(i=1;i<=n;i++) 
		for(j=1;j<=n;j++) 
			if(a[i][j]!=1) 
				if(a[i][k]==1 && a[k][j]==1) 
					a[i][j]=1;
}

	public static void main(String[] args) {
		int a[][] = new int[10][10];
		int n, i, j;
		System.out.println("Enter the number of vertices");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Enter the adjacency matrix");
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				a[i][j] = sc.nextInt();
		warshall w = new warshall();
		w.wshall(a, n);
		System.out.println("The shortest path matrix is");
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}