package binaryTreeR2;


public class Diameter {

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
		
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + (lh > rh ? lh : rh);
		
	}
	
	public static int max(int a, int b, int c) {
		if(a > b && a > c)
			return a;
		else if(b > a && b > c)
			return b;
		else
			return c;
	}
	
	public static int calDiameter(Node root) {
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		int ld = calDiameter(root.left);
		int rd = calDiameter(root.right);
		
		return max(ld, rd, 1 + lh + rh);
	}
	
	public static void diameter(Node root) {
		if(root == null)
			System.out.println(0);
		
	//	int height = height(root);
		System.out.println(calDiameter(root));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		diameter(root);

	}

}
