import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StageDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create an ImageView
        ImageView imageView = new ImageView();

        // Load an image from a file (provide the correct path)
        Image image = new Image("vaibhav.jpg");
        imageView.setImage(image);
      

        // Create a layout container (e.g., StackPane) and add the ImageView to it
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("ImageView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
