package accionlabs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

import javax.management.Query;

public class l1 {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;

		}
	}

	public void printBoundary(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		StringBuffer sb = new StringBuffer();
		sb.append(root.data);
		while (queue.size() > 0) {
			Node rem = queue.remove();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (i == 0 || i == size) {
					sb.append(rem.data);
				}
			}
			if (rem.left != null) {
				queue.add(rem.left);
			}
			if (rem.right != null) {
				queue.add(rem.right);
			}

		}

	}

	private void printleftNode(Node root) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// convert all upper to lowercase
		// all even numbers to odd number

		List<String> l1 = Arrays.asList("a", "b", "c", "2", "4", "6");
		// l1.stream().map(e-> e.toUpperCase()).map(e-> {(Character.isDigit(e) ?
		// Integer.parseInt(e%2 == 0) ? e+1 : e}).collect(Collectors.toList());

	}

}
