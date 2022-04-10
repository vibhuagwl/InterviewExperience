package mmt;

public class l2 {

	static int[][] arr = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
	static int xdir[] = { -1, 0, 1, 0 };
	static int ydir[] = { 0, -1, 0, 1 };
	static int count = 0;

	static int overallIslandCount = 0;

	static boolean[][] visited = new boolean[arr.length][arr[0].length];

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					System.out.println("row: " + i + " col : " + j);
					count++;
					int noofisland = 1;
					visited[i][j] = true;
					dfs(arr, i, j, noofisland, visited);
					System.out.println("overallIslandCount :" + overallIslandCount);
				}
			}
		}
		System.out.println(overallIslandCount);
	}

	public static void dfs(int[][] arr, int i, int j, int noofisland, boolean[][] visited) {
		arr[i][j] = -1;
		visited[i][j] = true;
		for (int k = 0; k < xdir.length; k++) {
			int new_row = xdir[k] + i;
			int new_col = ydir[k] + j;

			if (new_row < arr.length && new_row >= 0 && new_col < arr[0].length && new_col >= 0
					&& arr[new_row][new_col] == 1) {
				noofisland++;
				dfs(arr, new_row, new_col, noofisland, visited);
			}
		}
		if (overallIslandCount < noofisland) {
			overallIslandCount = noofisland;
		}
		arr[i][j] = 1;

	}

}
