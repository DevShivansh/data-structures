package binaryTree;

public class DiameterOfTree {

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

	public int height(Node root) {
		if (root == null)
			return 0;

		return (1 + Math.max(height(root.left), height(root.right)));
	}

	public int diameter() {
		return diameter(root);
	}

	public int diameter(Node root) {
		if (root == null)
			return 0;

		int lHeight = height(root.left);
		int rHeight = height(root.right);
		/***
		 * Return max of three: 
		 * > left height + right right + 1 
		 * > diameter of left subtree 
		 * > diameter of right sub tree
		 */
		return Math.max((lHeight + rHeight + 1), Math.max(diameter(root.left), diameter(root.right)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterOfTree program = new DiameterOfTree();
		program.root = new Node(1);

		program.root.left = new Node(2);
		program.root.right = new Node(3);

		program.root.left.left = new Node(4);
		program.root.left.right = new Node(5);

		System.out.println("Diamenter of tree is " + program.diameter());

	}

}
