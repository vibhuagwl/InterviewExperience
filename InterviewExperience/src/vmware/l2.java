package vmware;

import java.util.LinkedList;
import java.util.Queue;

public class l2 {
	// leetcode 11 https://leetcode.com/problems/container-with-most-water/
	public int maxArea(int[] height) {
		// 1,8,6,2,5,4,8,3,7
		int maxWater = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			int l = j - i;
			int h = Math.min(height[i], height[j]);
			int water = l * h;
			maxWater = Math.max(maxWater, water);

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxWater;
	}

	/**
	 * @param rooms: m x n 2D grid
	 * @return: nothing
	 */
	private static final int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public void wallsAndGates(int[][] rooms) {
		/*
		 * { 2147483647, -1, 0, 2147483647 }, 
		 * { 2147483647, 2147483647, 2147483647, -1},
		 * { 2147483647, -1, 2147483647, -1 }, 
		 * { 0, -1, 2147483647, 2147483647 } }
		 */
		// write your code here
		Queue<int[]> queue = new LinkedList();
		if (rooms == null || rooms.length == 0)
			return;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0)
					queue.add(new int[] { i, j });
			}
		}
		while (!queue.isEmpty()) {

			int[] top = queue.poll();
			for (int[] dir : dirs) {

				int i = top[0] + dir[0];
				int j = top[1] + dir[1];
				if (i >= 0 && j >= 0 && i < rooms.length && j < rooms[0].length) {
					if (rooms[i][j] == Integer.MAX_VALUE) {
						rooms[i][j] = rooms[top[0]][top[1]] + 1;
						queue.add(new int[] { i, j });
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		l2 l = new l2();
		l.wallsAndGates(new int[][] { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } });

	}

}
