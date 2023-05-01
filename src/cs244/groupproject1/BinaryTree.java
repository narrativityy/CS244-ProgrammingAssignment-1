package cs244.groupproject1;
import java.util.ArrayList;
public abstract class BinaryTree {

	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	//Made by William 4/21
	public void insert(int key) {
		
		if(root == null) {
			root = new Node(key);
			return;
		}
		root = insert(key, root);
	}
	
	//Made by William 4/21
	protected abstract Node insert(int key, Node root);
	
	public boolean search(int key) {
		return search(key, root);
	}
	//Made by William 4/21
	private boolean search(int key, Node root) {
		if(root == null) {
			return false;
		}
		if(root.getKey() == key) {
			return true;
		}
		else if(root.getKey() < key) {
			return search(key, root.getLeft());
		}
		else {
			return search(key, root.getRight());
		}
	}
	
	//Made by William 4/21
	public void remove(int key) {
		root = remove(key, root);
	}
	protected abstract Node remove(int key, Node root);
	
	public Node searchHighlight(int key, BinaryTree tree) {
		System.out.println("Starting search");
		return searchHighlight(key, tree.root);
	}
	//Made by John Gallagher 4/30
	public Node searchHighlight(int key, Node current) {
		
		if(current.getKey() == key) {
			System.out.println("found matching key");
			return current;
		}
		else if(current.getKey() < key) {
			System.out.println("Going left");
			return searchHighlight(key, current = current.getLeft());
		}
		else if(current.getKey() > key) {
			System.out.println("Going right");
			return searchHighlight(key, current = current.getRight());
		}else {
			return current;
		}
		
}
	
	//Made by William 4/21
	public int findMin(Node root) {
		if(root.getLeft() == null) {
			return root.getKey();
		}
		else {
			return findMin(root.getLeft());
		}
	}
	//Made by William 4/21
	public int findMax(Node root) {
		if(root.getRight() == null) {
			return root.getKey();
		}
		else {
			return findMax(root.getRight());
		}
	}

	public void getNodeCount() {// helper method to count total nodes.
	 countNodes(root);
	}
	
	
	
	private int countNodes(Node node) {  //Benjamin 4/27  // recusive method to count the total amount of nodes in the the respective bst tree
		if(node == null) {
	         
		return 0;
		}
	        else {
		
		return countNodes(node.getLeft()) + countNodes(node.getRight()) +  1;
			
		}
	
		
	}
	

public void clearTree() {// Benjamin 4/27 method to clear tree when called upon
	
	root =null;
}

 public void preorderTraversal(Node root) { //Benjamin 4/28
    if (root != null) {
        System.out.print(root.getKey() + " ");
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }
}
	
public  void postOrderTraversal(Node root) { //Benjamin 4/28
    if (root != null) {
      postOrderTraversal(root.getLeft());
      postOrderTraversal(root.getRight());
      System.out.print(root.getKey() + " ");
    }
}	

 public void inOrderTraversal (Node root) { // Benjamin 4/28
	 if(root != null) {
	 	inOrderTraversal(root.getLeft());
        System.out.print(root.getKey() + " ");
        inOrderTraversal(root.getRight());
	 }
	
	}
 
 public void inOrderTraversalToString(Node root, ArrayList<String> res) {
	 if(root != null) {
	 	inOrderTraversalToString(root.getLeft(), res);
	 	res.add(Integer.toString(root.getKey()));
	 	inOrderTraversalToString(root.getRight(), res);
	 }
 }
 
 public void postOrderTraversalToString(Node root, ArrayList<String> res) {
	 if(root != null) {
		 postOrderTraversalToString(root.getLeft(), res);
		 postOrderTraversalToString(root.getRight(), res);
		 res.add(Integer.toString(root.getKey()));
	 }
 }
 
 public void preOrderTraversalToString(Node root, ArrayList<String> res) {
	 if(root != null ) {
		 res.add(Integer.toString(root.getKey()));
		 preOrderTraversalToString(root.getLeft(), res);
		 preOrderTraversalToString(root.getRight(), res);
	 }
 }
}
