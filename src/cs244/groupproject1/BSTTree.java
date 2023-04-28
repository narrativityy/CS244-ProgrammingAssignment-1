package cs244.groupproject1;
public class BSTTree extends BinaryTree {

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
				Node parent = root.getRight();
				Node current = root.getRight();
				while(current.getLeft() != null) {
					parent = current;
					current = parent.getLeft();
				}
				parent.setLeft(current.getRight());
				root.setKey(current.getKey());
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
		return root;
		
	}
	
	private int countNodes(Node node) {  //Benjamin 4/27  // recusive method to count the total amount of nodes in the the respective bst tree
		if(node == null) {
	         
		return 0;
		}
	        else {
		
		return countNodes(node.getLeft()) + countNodes(node.getRight()) +  1;
			
		}
	
		
	}
}
