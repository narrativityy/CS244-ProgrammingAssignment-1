package cs244.groupproject1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("BST and AVLTree Visualizer");
        TextField textField = new TextField();
        textField.setPrefColumnCount(2);
        textField.setAlignment(Pos.TOP_LEFT);
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button performance = new Button("Performance");

        // Jake 4/28/23
        performance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Test");
                alert.show();
            }
        });
        HBox hbox = new HBox(5);
        Menu dropMenu = new Menu("Select a type of tree");
        dropMenu.getItems().addAll(new MenuItem("AVL Tree"), new MenuItem("BS Tree"), new MenuItem("Binary Tree"));
        MenuBar mb = new MenuBar();
        mb.getMenus().add(dropMenu);

        hbox.getChildren().addAll(mb, textField, insert, delete, performance);
        hbox.setAlignment(Pos.TOP_CENTER);

        StackPane root = new StackPane();
        root.getChildren().add(hbox);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }

    public void performanceMetrics() {

    }

    public static void main(String[] args) {
        launch();
    }
}