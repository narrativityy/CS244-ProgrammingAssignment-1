import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BST and AVLTree Visualizer");
        TextField textField = new TextField();
        textField.setPrefColumnCount(2);
        textField.setAlignment(Pos.TOP_LEFT);
        Button insert = new Button("Instert");
        Button delete = new Button("Delete");
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(textField, insert, delete);
        hbox.setAlignment(Pos.TOP_CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(hbox);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }

}
