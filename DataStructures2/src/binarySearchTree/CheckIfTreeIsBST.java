package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import binarySearchTree.PredessorAndSuccesor.Node;

public class CheckIfTreeIsBST {
	
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
	
	public static Node insert(Node root,int data) {
		if(root==null)
			return new Node(data);
		
		if(root.data>=data) {
			root.left = insert(root.left, data);
		}else {
			root.right = insert(root.right, data);
		}
		return root;
		
	}
	
	public static void inOrder(Node root, List<Integer> sortedList) {
		if(root==null)
			return;
		
		inOrder(root.left, sortedList);
		sortedList.add(root.data);
		inOrder(root.right, sortedList);
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
		
		List<Integer> sortedList = new ArrayList<>();
		
		inOrder(root, sortedList);
		
		boolean flag = true;
		int min = -1;
		for(Integer i : sortedList) {
			System.out.println(i);
			if(min<i) {
				min = i;
			}else {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("BST");
		}else {
			System.out.println("Not BST");
		}

	}

}
