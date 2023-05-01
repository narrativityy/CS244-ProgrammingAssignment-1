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
	private int vertInc = 30;
	private int horzInc = 60;
	private int width = 1000;
	private int height = 100;
	BTreePane(BinaryTree tree){
		this.tree = tree;
		setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void drawTree() {
		this.getChildren().clear();
		drawTree(tree.root, radius, height, width / 2);
	}
	//Made by John Gallagher 4/30
	protected void drawTree(Node current, double radius, int y, int x) {
		//left - right +
		if(current.getLeft() != null) {
			getChildren().add(new Line(x, y, x - horzInc, y + vertInc));
			drawTree(current.getLeft(), radius, y + vertInc,  x - horzInc);
		}
		if(current.getRight() != null) {
			getChildren().add(new Line(x, y, x + horzInc, y + vertInc));
			drawTree(current.getRight(), radius, y + vertInc, x + horzInc);
		}
		
		
		
		Circle circle = new Circle(x, y, radius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.WHITE);
		getChildren().addAll(circle, new Text(x - 5, y + 5, Integer.toString(current.getKey())));
	}

}
