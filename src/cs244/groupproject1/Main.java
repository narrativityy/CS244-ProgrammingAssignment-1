package cs244.groupproject1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;

public class Main extends Application {
	
	AVLTree aTree;
	BSTTree bTree;
	boolean isATree;
	StackPane root;
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
        
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button search = new Button("Search");
        insert.setOnAction(insertButton());
        HBox hbox = new HBox(5);
        
        Menu dropMenu = new Menu("Select a type of tree");
        MenuItem avlTree = new MenuItem("AVL Tree");
        MenuItem bsTree = new MenuItem("BST");
        bsTree.setOnAction(treeSelect());
        avlTree.setOnAction(treeSelect());
        dropMenu.getItems().addAll(avlTree, bsTree);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(dropMenu);
        hbox.getChildren().addAll(mb, textField, insert, delete, search);
        hbox.setAlignment(Pos.TOP_CENTER);
        root = new StackPane();
        root.getChildren().add(hbox);
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private EventHandler<ActionEvent> treeSelect() {
    	return new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			MenuItem tempItem = (MenuItem) event.getSource();
			String treeT = tempItem.getText();
			if("bst".equalsIgnoreCase(treeT)) {
				bTree = null;
				bTree = new BSTTree();
				System.out.println("Dats a Btree");
				isATree = false;
			}
			if("avl tree".equalsIgnoreCase(treeT)) {
				aTree = null;
				aTree = new AVLTree();
				System.out.println("Dats a tree");
				isATree = true;
			}
		}	
    	};
    	
    }
    
    private EventHandler<ActionEvent> insertButton() {
    	return new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event) {
    			if(isATree == true) {
    				aTree.insert(0);
    			}
    		}
    	};
    }

}
