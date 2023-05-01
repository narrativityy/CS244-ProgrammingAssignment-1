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
	public BinaryTree tree;
	
	
	public static void main(String[] args) {
        launch(args);
    }
	//Made by John Gallagher 4/25
	
    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("BST and AVLTree Visualizer");
        primaryStage.getIcons().add(new Image("/digitaltree.png"));
        TextField textField = new TextField();
        textField.setPrefColumnCount(2);
        textField.setAlignment(Pos.TOP_LEFT);
        
        tree = new BSTTree();
    	StackPane root = new StackPane();
        BTreePane treePane = new BTreePane(tree);
        //Made by John Gallagher 4/30
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button search = new Button("Search");
        Button traverse = new Button("Traverse");
        HBox hbox = new HBox(5);
        Menu dropMenu = new Menu("Select a type of tree");
        MenuItem avlTree = new MenuItem("AVL Tree");
        MenuItem binarySearch = new MenuItem("Binary Search");
        dropMenu.getItems().addAll(avlTree, binarySearch);
        MenuBar mb = new MenuBar();
        //Made by John Gallagher 4/27
        avlTree.setOnAction(e -> {
        	tree = null;
        	tree = new AVLTree();
        	nodeKeys.clear();
        	treePane.setPane(tree);
        });
        //Made by John Gallagher 4/27
        binarySearch.setOnAction(e -> {
        	tree = null;
        	tree = new BSTTree();
        	nodeKeys.clear();
        	treePane.setPane(tree);
        });
        //Made by John Gallagher 4/27
        insert.setOnAction(e -> {
        	int key = Integer.parseInt(textField.getText());
        	nodeKeys.add(key);
        	tree.insert(key);
        	treePane.drawTree();
        }); 
        //Made by John Gallagher 4/30
        delete.setOnAction(e -> {
        	int key = Integer.parseInt(textField.getText());
        	nodeKeys.remove(Integer.valueOf(key));
        	tree.remove(key);
        	treePane.drawTree();
        });
        //Made by John Gallagher 4/30
        search.setOnAction(e -> {
        	int key = Integer.parseInt(textField.getText());
        	treePane.highlightNode(key);
        });
        //Made by John Gallagher 4/30
        traverse.setOnAction(e -> {
        	treePane.prepareOutput();
        });
        
        mb.getMenus().add(dropMenu);
        hbox.getChildren().addAll(mb, textField, insert, delete, search, traverse);
        hbox.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(treePane, hbox);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
 
    }
    
}
