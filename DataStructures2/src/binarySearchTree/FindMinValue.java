package binarySearchTree;

public class FindMinValue {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node() {
			
		}
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//insert data in BST
	public static Node insert(Node root, int data) {
		if(root == null )
			return new Node(data);
		
		if(root.data>= data) {
			root.left = insert(root.left, data);
		}else {
			root.right = insert(root.right, data);
		}
		return root;
		
	}
	
	
	//inorder traversal of BST
	public static void traverse(Node node) {
		
		if(node ==null)
			return;
		
		traverse(node.left);
		System.out.println(node.data);
		traverse(node.right);
		
	}
	
	
	public static int findMin(Node node) {
		if(node.left==null)
			return node.data;
		
		return findMin(node.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		root = insert(root, 4);
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
		insert(root, 5);
		
		traverse(root);
		System.out.println("\nMin value is " + findMin(root));
		

	}

}
