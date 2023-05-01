package cs244.groupproject1;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

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
		if(tree.search(key) == true) {
			Node current = tree.searchHighlight(key);
			current.circ.setFill(Color.YELLOW);
		}
	}

}
