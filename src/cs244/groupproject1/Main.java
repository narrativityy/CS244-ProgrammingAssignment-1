package cs244.groupproject1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class Main extends Application {
	static ArrayList<Integer> nodeKeys = new ArrayList();
	public static int width = 1000;
	public static int height = 800;
	public static void main(String[] args) {
        launch(args);
    }
	//Made by John Gallagher 4/25
	
    @Override
    public void start(Stage primaryStage) {
    	BinaryTree tree = new BSTTree();
    	StackPane root = new StackPane();
        BTreePane treePane = new BTreePane(tree);
        primaryStage.setTitle("BST and AVLTree Visualizer");
        primaryStage.getIcons().add(new Image("/digitaltree.png"));
        TextField textField = new TextField();
        textField.setPrefColumnCount(2);
        textField.setAlignment(Pos.TOP_LEFT);
        Button insert = new Button("Insert");
        //Made by John Gallagher 4/30
        insert.setOnAction(e -> {
        	int key = Integer.parseInt(textField.getText());
        	nodeKeys.add(key);
        	tree.insert(key);
        	treePane.drawTree();
        }); 
        Button delete = new Button("Delete");
        delete.setOnAction(e -> {
        	int key = Integer.parseInt(textField.getText());
        	nodeKeys.remove(Integer.valueOf(key));
        	tree.remove(key);
        	treePane.drawTree();
        	
        });
        HBox hbox = new HBox(5);
        Menu dropMenu = new Menu("Select a type of tree");
        dropMenu.getItems().addAll(new MenuItem("AVL Tree"), new MenuItem("BS Tree"), new MenuItem("Binary Tree"));
        MenuBar mb = new MenuBar();
        mb.getMenus().add(dropMenu);
        
        hbox.getChildren().addAll(mb, textField, insert, delete);
        hbox.setAlignment(Pos.TOP_CENTER);
        
      
        
        root.getChildren().addAll(treePane, hbox);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        
        
        
    }
    
}
