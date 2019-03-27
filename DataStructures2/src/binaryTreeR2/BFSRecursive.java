package binaryTreeR2;

public class BFSRecursive {
	
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
	
	public static int height(Node root) {
		if(root == null ) {
			return 0;
		}
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		return 1 + (lheight > rheight ? lheight : rheight);
	}
	
	public static void printGivenLevel(Node root, int l) {
		if(root== null)
			return;
		
		if( l==1 ) {
			System.out.print(root.data + "\t");
			return;
		}else {
			printGivenLevel(root.left, l - 1);
			printGivenLevel(root.right, l - 1);
		}
	}
	
	public static void BFS(Node root) {
		if(root == null ) {
			return;
		}
		int height = height(root);
		for(int i=1;i<=height;i++) {
			printGivenLevel(root, i);
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
