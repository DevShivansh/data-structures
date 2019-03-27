package binaryTreeR2;

import java.util.LinkedList;
import java.util.Queue;

public class BFSQueue {
	
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			left = right = null;
		}
	}
	
	public static void BFS(Node root) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + "\t");
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		BFS(root);
	}

}
