package binaryTree;

public class HeightOfTree {

	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public int getHeight() {
		
		return getHeight(root);
		
	}
	
	public int getHeight(Node root) {
		if(root==null)
			return 0;
		
		return 1 + (Math.max(getHeight(root.left), getHeight(root.right)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeightOfTree program = new HeightOfTree();
		program.root = new Node(1);
		
		program.root.left = new Node(2);
		program.root.right = new Node(3);

		program.root.left.left = new Node(4);
		program.root.left.right = new Node(5);
		
		System.out.println("Height of tree is :" + program.getHeight());
	}

}
