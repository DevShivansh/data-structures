package binaryTree;

import java.util.LinkedList;

public class BFS {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	Node root;

	public void printLevelOrder(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data);

			if (temp.left != null)
				queue.addLast(temp.left);

			if (temp.right != null)
				queue.addLast(temp.right);
		}
	}

	public static void main(String[] args) {
		BFS bfs = new BFS();
		bfs.root = new Node(1);

		bfs.root.left = new Node(2);
		bfs.root.right = new Node(3);

		bfs.root.left.left = new Node(4);
		bfs.root.left.right = new Node(5);

		System.out.println("Level order traversal or BFS : \n");
		bfs.printLevelOrder(bfs.root);

	}

}
