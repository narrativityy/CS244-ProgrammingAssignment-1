package cs244.groupproject1;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;

// Made by John Gallagher 4/30
public class BTreePane extends Pane{
	
	private BinaryTree tree;
	private double radius = 15;
	private double vertInc = 50;
	private double horzInc = 200;
	private double width = 1000;
	private double height = 100;
	
	BTreePane(BinaryTree tree){
		setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setPane(BinaryTree tree) {
		this.tree = null;
		this.tree = tree;
	}
	
	public void updateTree(BinaryTree tree) {
		this.tree = tree;
	}
	
	public void drawTree() {
		this.getChildren().clear();
		drawTree(tree.root, radius, height, width / 2, vertInc, horzInc);
	}
	//Made by John Gallagher 4/30
	protected void drawTree(Node current, double radius, double y, double x, double vertInc, double horzInc) {
		//left - right +
		if(current.getLeft() != null) {
			getChildren().add(new Line(x, y, x  - horzInc, y + vertInc));
			drawTree(current.getLeft(), radius, y + vertInc,  x  - horzInc, vertInc / 2, horzInc / 2);
		}
		if(current.getRight() != null) {
			getChildren().add(new Line(x, y, x + horzInc, y + vertInc));
			drawTree(current.getRight(), radius, y + vertInc, x  + horzInc, vertInc / 2, horzInc / 2);
		}
		
		
		
		current.circ = new Circle(x, y, radius);
		current.circ.setFill(Color.WHITE);
		current.circ.setStroke(Color.WHITE);
		getChildren().addAll(current.circ, new Text(x - 5, y + 5, Integer.toString(current.getKey())));
	}
	
	public void highlightNode(int key) {
			Node current = tree.searchHighlight(key, tree);
			current.circ.setFill(Color.YELLOW);
		
	}
	//Made by John Gallagher 4/30
	public void prepareOutput() {
		ArrayList<String> outputs = new ArrayList<>();
		tree.inOrderTraversalToString(tree.root, outputs);
		String inOrder = outputs.toString();
		outputs.clear();
		tree.preOrderTraversalToString(tree.root, outputs);
		String preOrder = outputs.toString();
		outputs.clear();
		tree.postOrderTraversalToString(tree.root, outputs);
		String postOrder = outputs.toString();
		
		inOrder.replace(" ", ",");
		preOrder.replace(" ", ",");
		postOrder.replace(" ", ",");
		
		Text preOrderText = new Text();
		Text postOrderText = new Text();
		Text inOrderText = new Text();
		
		
		preOrderText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		postOrderText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		inOrderText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		preOrderText.setX(50);
		preOrderText.setY(650);
		inOrderText.setX(50);
		inOrderText.setY(670);
		postOrderText.setX(50);
		postOrderText.setY(690);
		preOrderText.setText("PreOrder Traversal: " + preOrder);
		postOrderText.setText("PostOrder Traversal" + postOrder);
		inOrderText.setText("In-Order" + inOrder);
		
		getChildren().addAll(preOrderText, postOrderText, inOrderText);
		
		
	}

}
