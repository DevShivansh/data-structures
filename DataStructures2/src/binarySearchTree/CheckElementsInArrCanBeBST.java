package binarySearchTree;

import java.util.LinkedList;

public class CheckElementsInArrCanBeBST {
	
	static class NodeData{
		int data;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
	}
	
	public static boolean solution(int[] arr, int n) {
		int i =0;
		NodeData node  = new NodeData();
		node.data = arr[i++];
		node.max = Integer.MAX_VALUE;
		node.min = Integer.MIN_VALUE;
		LinkedList<NodeData> queue = new LinkedList<>();
		queue.add(node);
		
		while( i!=n && !queue.isEmpty()) {
			NodeData temp = queue.removeFirst();
			
			if( i < n && temp.min < arr[i] && temp.data > arr[i]) {
				NodeData newNode = new NodeData();
				newNode.data = arr[i++];
				newNode.min = temp.min;
				newNode.max = temp.data;
				queue.addLast(newNode);
			}
			
			if( i < n && temp.max > arr[i] && temp.data < arr[i]) {
				NodeData newNode = new NodeData();
				newNode.data = arr[i++];
				newNode.min = temp.data;
				newNode.max = temp.max;
				queue.addLast(newNode);
			}
			
		}
		
		if( i==n )
			return true;
		
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{7, 4, 12, 3, 6, 8, 1, 5, 10};
		int arr2[] = new int[] {11, 6, 13, 5, 12, 10};
		System.out.println(solution(arr, arr.length));
		System.out.println(solution(arr2, arr2.length));

	}

}
