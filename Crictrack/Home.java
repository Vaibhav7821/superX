package Crictrack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a StackPane
        primaryStage.setMaximized(true);
        StackPane stackPane = new StackPane();

        // Load the image from the file in the same directory
        Image image = new Image("file:C:\\Users\\Vaibhav\\Desktop\\java\\super-x-projects\\Crictrack\\backImg.jpg"); // Replace "image.png" with the actual image file name

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());
        // Add the ImageView to the StackPane
        stackPane.getChildren().add(imageView);

        Font buttonFont = Font.font("Calibri", 20);
        Button switchButton = createGlowButton("LAUNCH PROJECT", Color.BROWN);
        switchButton.setFont(buttonFont);

        
        VBox vb = new VBox(100);
        vb.getChildren().add(switchButton);
        vb.setAlignment(Pos.BOTTOM_CENTER);
        vb.setPadding(new Insets(0, 0, 100, 0));

        stackPane.getChildren().add(vb);
        // Create a Scene and set the StackPane as its root
        Scene scene = new Scene(stackPane, 400, 400);

        // Set the Scene on the Stage and show the Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image in StackPane");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

        public static Button createGlowButton(String text, Color glowColor) {
        Button button = new Button(text);
        button.setStyle("-fx-base: " + toHex(glowColor) + ";");
        button.setEffect(new DropShadow());

        button.setOnMouseEntered(e -> {
            Glow glow = new Glow(0.7);
            glow.setInput(button.getEffect());
            button.setEffect(glow);
        });

        button.setOnMouseExited(e -> {
            button.setEffect(new DropShadow());
        });

        return button;
    };

    public static String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    };
    public static void main(String[] args) {
        launch(args);
    }
}
