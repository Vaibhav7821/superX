package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the primary window
        primaryStage.setTitle("Primary Window");
        StackPane primaryLayout = new StackPane();

        Image backgroundImage = new Image("dark.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        Image image = new Image("Blueback.jpg");
        ImageView imageView = new ImageView(image);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        imageView.setFitWidth(400); // Set the desired width
        imageView.setFitHeight(400); // Set the desired height

        // Create an HBox layout to contain the image
        HBox hbox = new HBox(imageView);

        // Set the position of the HBox (move it to the right)
        hbox.setPadding(new Insets(10, 50, 100, 500));
        // Add the ImageView to the container
        primaryLayout.getChildren().add(backgroundImageView);
        // Create a button to switch to another window
        Button switchButton = new Button("Switch to Another Window");

        MainProject obj1 = new MainProject();
        switchButton.setOnAction(e -> obj1.nextWindow(primaryStage));
        // BorderPane.setMargin(switchButton, new Insets(10, 20, 300, 400));
        // StackPane primaryLayout = new StackPane();
        primaryLayout.getChildren().add(switchButton);
        primaryLayout.getChildren().add(imageView);
        primaryLayout.getChildren().add(hbox);

        Scene primaryScene = new Scene(primaryLayout, 300, 200);
        primaryStage.setScene(primaryScene);
        // borderPane.setRight(switchButton);

        // Show the primary window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
