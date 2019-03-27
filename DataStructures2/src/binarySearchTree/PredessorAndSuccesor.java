package binarySearchTree;

import binarySearchTree.FindMinValue.Node;

public class PredessorAndSuccesor {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			left = right = null;
		}
	}
	
	public static Node insert(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		
		if(root.data >= data) {
			root.left = insert(root.left, data);
		}else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public static  void findPreAndSucc(Node root, Node pre, Node succ, int key) {
		if(root==null)
			return ;
		
		if( root.data == key) {
			
			pre = root.left;
			while(pre.right!=null) {
				pre = pre.right;
			}
			
			succ = root.right;
			
			while(succ.left!=null) {
				succ = succ.left;
			}
			
		}
		
		if( root.data >=key) {
			succ = root;
			findPreAndSucc(root.left, pre, succ, key);
		}else {
			pre = root;
			findPreAndSucc(root.right, pre, succ, key);
		}
		
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

		Node pre = null;
		Node succ = null;
		findPreAndSucc(root, pre, succ, 65);
		
		if(pre==null) {
			System.out.println("No predecessor");
		}else{
			System.out.println("Predecessor : " + pre.data);
		}
		
		if(succ==null) {
			System.out.println("No Successor");
		}else{
			System.out.println("Successor : " + succ.data);
		}
		
		
	}

}
