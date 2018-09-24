package binaryTree;

public class DFS {
	
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
	}
	
	Node root;
	
	public void preorder(Node root) {
		if( root == null) {
			return;
		}
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	public void inorder(Node root) {
		if ( root == null )
			return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	public void postorder(Node root) {
		if ( root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS dfs = new DFS();
		dfs.root = new Node(1);
		
		dfs.root.left = new Node(2);
		dfs.root.right = new Node(3);
		
		dfs.root.left.left = new Node(4);
		dfs.root.left.right = new Node(5);
		
		dfs.root.right.left = new Node(6);
		dfs.root.right.right = new Node(7);
		
		System.out.println("Preorder\n");
		dfs.preorder(dfs.root);
		System.out.println("\n\nInorder\n");
		dfs.inorder(dfs.root);
		System.out.println("\n\nPostOrder\n");
		dfs.postorder(dfs.root);
		

	}

}
