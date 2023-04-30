package cs244.groupproject1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AVLTree extends BinaryTree {
	
	private int totalRotationsPeformed;
	private int rightRotationsPeformed;
	private int leftRotationsPeformed;
	
	//Made by William 4/21
	public AVLTree() {
		super();
		totalRotationsPeformed = 0;
		rightRotationsPeformed = 0;
		leftRotationsPeformed = 0;
	}
	
	public int getRightRotations() {
		return rightRotationsPeformed;
	}
	public int getLeftRotations() {
		return leftRotationsPeformed;
	}
	public int getTotalRotations() {
		return totalRotationsPeformed;
	}

	//Made by William 4/21
	@Override
	protected Node insert(int key, Node root) {
		if(root == null) {
			return new Node(key);
		}
		else if(key < root.getKey()) {
			root.setLeft(insert(key, root.getLeft()));
		}
		else {
			root.setRight(insert(key, root.getRight()));
		}
		
		root.setHeight();
		root.setBalanceFactor();

		checkBalanceFactor(root);
		
		return root;
		
	}

	//Made by William 4/21
	@Override
	protected Node remove(int key, Node root) {
		if(root == null) {
			return root;
		}
		if(key == root.getKey()) {
			//2 children
			if(root.getLeft() != null && root.getRight() != null) {
				//Traverses all the way to the left of the right subtree and deletes that node
				//Then gives the deleted node's key to the root
				
				int min = findMin(root.getRight());
				root.setRight(remove(min, root.getRight()));
				root.setKey(min);
			}
			//1 child
			else if(root.getLeft() != null) {
				return root.getLeft();
			}
			else if(root.getRight() != null) {
				return root.getRight();
			}
			//0 children
			else {
				return null;
			}
		}
		else if(key < root.getKey()) {
			root.setLeft(remove(key, root.getLeft()));
		}
		else {
			root.setRight(remove(key, root.getRight()));
		}
		
		root.setHeight();
		root.setBalanceFactor();
		
		checkBalanceFactor(root);
		
		return root;
	}
	
	//Made by William 4/21
	private Node checkBalanceFactor(Node root) {
		if(Math.abs(root.getBalanceFactor()) == 2) {
			//right is the heavy side
			if(root.getBalanceFactor() < 0) {
				//Right left
				if(root.getRight().getBalanceFactor() > 0) {
					root.setRight(rotateRight(root.getRight()));
				}
				root = rotateLeft(root);
			}
			//left is the heavy side
			else {
				//left right
				if(root.getLeft().getBalanceFactor() < 0) {
					root.setLeft(rotateLeft(root.getLeft()));
				}
				root = rotateRight(root);
			}
		}
		return root;
	}
	
	//Made by William 4/21
	private Node rotateLeft(Node root) {
		Node newRoot = root.getRight();
		root.setRight(newRoot.getLeft());
		newRoot.setLeft(root);
		
		root.setHeight();
		newRoot.setHeight();
		
		leftRotationsPeformed++;
		totalRotationsPeformed++;
		
		return newRoot;
	}
	
	//Made by William 4/21
	private Node rotateRight(Node root) {
		Node newRoot = root.getLeft();
		root.setLeft(newRoot.getRight());
		newRoot.setRight(root);
		
		root.setHeight();
		newRoot.setHeight();
		
		rightRotationsPeformed++;
		totalRotationsPeformed++;
		
		return newRoot;
	}

}
