package binaryTree;

import java.util.Stack;

public class DFSNonRecursive {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public void preorderNonRecursive(Node root) {
		
		Stack<Node> stack = new Stack<>();
		while(true) {
			while(root!=null) {
				System.out.print(root.data);
				stack.push(root);
				root = root.left;
			}
			
			if ( stack.isEmpty())
				break;
			
			root = stack.pop();
			root = root.right;
		}
	}
	
	public void inorder(Node root) {
		
		Stack<Node> stack = new Stack<>();
		while(true) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			if( stack.isEmpty())
				break;
			
			root = stack.pop();
			System.out.print(root.data);
			root = root.right;
		}
	}
	
	/*public void postorder(Node root) {
		Stack<Node> stack = new Stack<>();
		
		while(true) {
			while(root != null ) {
				stack.push(root);
				root
			}
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSNonRecursive tree = new DFSNonRecursive();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Preorder traversal : \n");
		tree.preorderNonRecursive(tree.root);
		
		System.out.println("\n\nInorder Traversal : \n");
		tree.inorder(tree.root);
		

	}

}
