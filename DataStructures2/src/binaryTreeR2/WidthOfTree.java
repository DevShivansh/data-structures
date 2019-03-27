package binaryTreeR2;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {
	
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
	
	public static int width(Node root) {
		if(root == null)
			return 0;
		int width = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while( !queue.isEmpty() ) {
			int count = queue.size();
			width = count > width ? count : width;
			
			while(count-- > 0 ) {
				Node temp = queue.poll();
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
		return width;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		System.out.println(width(root));

	}

}
