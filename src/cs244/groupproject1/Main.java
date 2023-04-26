package cs244.groupproject1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;


public class Main extends Application {

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
        HBox hbox = new HBox(5);
        Menu dropMenu = new Menu("Select a type of tree");
        dropMenu.getItems().addAll(new MenuItem("AVL Tree"), new MenuItem("BS Tree"), new MenuItem("Binary Tree"));
        MenuBar mb = new MenuBar();
        mb.getMenus().add(dropMenu);
        
        hbox.getChildren().addAll(mb, textField, insert, delete);
        hbox.setAlignment(Pos.TOP_CENTER);
        
        StackPane root = new StackPane();
        root.getChildren().add(hbox);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }

}
