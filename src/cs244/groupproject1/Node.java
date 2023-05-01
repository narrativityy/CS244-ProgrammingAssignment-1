package cs244.groupproject1;
import javafx.scene.shape.*;
//The node class was made by William: 4/21 
public class Node {
	
	private int key;
	private Node right;
	private Node left;
	
	//These won't be used for the BST
	private int height;
	private int balanceFactor;
	public Circle circ;
	public Node(int k) {
		right = null;
		left = null;
		key = k;
		
		height = 1;
		balanceFactor = 0;
		circ = new Circle(50,50,50);
		
	}
	
	public Node getRight() {
		return right;
	}
	public Node getLeft() {
		return left;
	}
	public int getKey() {
		return key;
	}
	
	public void setRight(Node r) {
		right = r;
	}
	public void setLeft(Node r) {
		left = r;
	}
	public void setKey(int k) {
		key = k;
	}
	
	public void setHeight() {
		int rightHeight, leftHeight;
		if(right != null) {
			rightHeight = right.getHeight();
		}
		else {
			rightHeight = 0;
		}
		
		if(left != null) {
			leftHeight = left.getHeight();
		}
		else {
			leftHeight = 0;
		}
		height = Math.max(rightHeight, leftHeight) + 1;
	}
	public void setBalanceFactor() {
		int rightHeight, leftHeight;
		if(right != null) {
			rightHeight = right.getHeight();
		}
		else {
			rightHeight = 0;
		}
		
		if(left != null) {
			leftHeight = left.getHeight();
		}
		else {
			leftHeight = 0;
		}
		balanceFactor = leftHeight - rightHeight;
	}
	
	public int getHeight() {
		return height;
	}
	public int getBalanceFactor() {
		return balanceFactor;
	}
	

}
