

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        BarChart bc = new BarChart();
        root.getChildren().add(bc);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}